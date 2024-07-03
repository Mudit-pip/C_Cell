package com.lnmiit.c_cell;


import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.rive.runtime.kotlin.RiveAnimationView;

public class recyclerviewAdapter extends RecyclerView.Adapter<recyclerviewAdapter.recyclerVH> {


    List<location_details> location_detailsList;
    MainActivity mainActivity;

    public recyclerviewAdapter(MainActivity mainActivity, List<location_details> location_detailsList) {
        this.mainActivity = mainActivity;
        this.location_detailsList = location_detailsList;
    }


    @NonNull
    @Override
    public recyclerviewAdapter.recyclerVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_navigating_location, parent, false);
        return new recyclerVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerviewAdapter.recyclerVH holder, int position) {

        location_details locationDetails = location_detailsList.get(position);

        holder.txtDetails.setText(locationDetails.getDetails());
        holder.txtLocation.setText(locationDetails.getLocation());
        holder.location_goto_btn.setText("Go To Location");
        holder.image_top.setImageResource(locationDetails.getImage_id());

        SharedPreferences sharedPreferences = mainActivity.getSharedPreferences("sp_c_cell", mainActivity.MODE_PRIVATE);
        boolean ischecked = sharedPreferences.getBoolean("key_" + position, false);
        holder.checkbox.setChecked(ischecked);


        if(ischecked) {
            holder.txt_stepcount.setVisibility(View.GONE);
            holder.rive_success_animation.setVisibility(View.VISIBLE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    holder.rive_success_animation.stop();
                }
            }, 1500);
        } else {
            holder.txt_stepcount.setVisibility(View.VISIBLE);
            holder.rive_success_animation.setVisibility(View.GONE);
            holder.txt_stepcount.setText("" + (position+1));
        }


        // Update expandable state
        if (position == getFirstNonCheckedPosition()) {
            locationDetails.setExpandable(true);
        } else {
            locationDetails.setExpandable(false);
        }

        boolean isExpandable = locationDetails.isExpandable();
        holder.expandable_layout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);
    }

    // Method to get the first non-checked position
    private int getFirstNonCheckedPosition() {
        SharedPreferences sharedPreferences = mainActivity.getSharedPreferences("sp_c_cell", mainActivity.MODE_PRIVATE);
        for (int i = 0; i < location_detailsList.size(); i++) {
            if (!sharedPreferences.getBoolean("key_" + i, false)) {
                return i;
            }
        }
        return -1; // return -1 if all are checked
    }

    @Override
    public int getItemCount() {
        return location_detailsList.size();
    }


    public class recyclerVH extends RecyclerView.ViewHolder {

        TextView txtDetails, txtLocation, txt_stepcount;
        Button location_goto_btn;
        CheckBox checkbox;
        LinearLayout expandable_layout, main_layout;
        ImageView image_top;
        RiveAnimationView rive_success_animation;

        public recyclerVH(@NonNull View itemView) {
            super(itemView);

            txtDetails = itemView.findViewById(R.id.item_nav_details_lbl);
            txtLocation = itemView.findViewById(R.id.item_nav_location_lbl);
            location_goto_btn = itemView.findViewById(R.id.item_nav_goto_btn);
            checkbox = itemView.findViewById(R.id.item_checkbox);
            txt_stepcount = itemView.findViewById(R.id.item_item_stepcount);
            image_top = itemView.findViewById(R.id.item_image);

            expandable_layout = itemView.findViewById(R.id.item_expandable_layout);
            main_layout = itemView.findViewById(R.id.item_main_layout);

            rive_success_animation = itemView.findViewById(R.id.item_success_rive);


            main_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    location_details locationDetails = location_detailsList.get(getAdapterPosition());
                    locationDetails.setExpandable(!locationDetails.isExpandable());
//                    notifyItemChanged(getAdapterPosition());

                    boolean isExpandable = locationDetails.isExpandable();
                    expandable_layout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);
                }
            });

            location_goto_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(getAdapterPosition() == 0){
                        AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity);
                        builder.setTitle("Which hostel do you want to go?");
                        builder.setItems(new CharSequence[]{"Boys Hostel", "Girls Hostel"},
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        switch (which) {
                                            case 0:
                                                // Boys Hostel selected
                                                mainActivity.open_google_maps(mainActivity.boyshostel_latitude, mainActivity.boyshostel_longitude);
                                                break;
                                            case 1:
                                                // Girls Hostel selected
                                                mainActivity.open_google_maps(mainActivity.girlshostel_latitude, mainActivity.girlshostel_longitude);
                                                break;
                                        }
                                    }
                                });
                        builder.create().show();
                    } else {
                        location_details locationDetails = location_detailsList.get(getAdapterPosition());
                        mainActivity.open_google_maps(locationDetails.getLatitude(), locationDetails.getLongitude());
                    }
                }
            });

            checkbox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences sharedPreferences = mainActivity.getSharedPreferences("sp_c_cell", mainActivity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("key_" + getAdapterPosition(), checkbox.isChecked());
                    editor.apply();

                    if(checkbox.isChecked()){
                        txt_stepcount.setVisibility(View.GONE);
                        rive_success_animation.setVisibility(View.VISIBLE);

                        rive_success_animation.reset();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                rive_success_animation.stop();
                                notifyItemChanged(getAdapterPosition());

                                if(getAdapterPosition()+1 < location_detailsList.size()) {
                                    notifyItemChanged(getAdapterPosition() + 1);
                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity);
                                    builder.setTitle("Completed All Steps");
                                    builder.setMessage("Now you can Login as Student with the Provided College Credentials");
                                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    });

                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                }
                            }
                        }, 1500);
                    } else {
                        txt_stepcount.setVisibility(View.VISIBLE);
                        txt_stepcount.setText((getAdapterPosition()+1)+"");
                        rive_success_animation.setVisibility(View.GONE);
                    }
                }
            });
        }

    }
}
