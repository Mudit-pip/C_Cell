package com.lnmiit.c_cell.gymkhana;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.lnmiit.c_cell.ListViewUtil;
import com.lnmiit.c_cell.R;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

public class inside_club_fest_gymkhana extends AppCompatActivity {

    private int[] images = {R.drawable.eminence_logo,
            R.drawable.eminence_logo, R.drawable.eminence_logo};
    ImageCarousel carousel;
    ListView personlist;
    ImageView insta_img, youtube_img, gmail_img, clublogo_img, mainimage;
    TextView main_info_lbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inside_club_fest_gymkhana);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        carousel = findViewById(R.id.carousel);
        personlist = findViewById(R.id.inside_clubfest_peopleinfo_list);
        insta_img = findViewById(R.id.inside_clubfest_insta_img);
        gmail_img = findViewById(R.id.inside_clubfest_gmail_img);
        youtube_img = findViewById(R.id.inside_clubfest_youtube_img);
        clublogo_img = findViewById(R.id.inside_clubfest_main_image);
        mainimage = findViewById(R.id.inside_clubfest_main_image);
        main_info_lbl = findViewById(R.id.inside_clubfest_info_lbl);

        Intent intent = getIntent();
        int clublogo_address = intent.getIntExtra("club_img", R.drawable.aaveg_logo);
        String insta = intent.getStringExtra("insta");
        String gmail = intent.getStringExtra("gmail");
        String youtube = intent.getStringExtra("youtube");
        String[] name = intent.getStringArrayExtra("name");
        String[] designation = intent.getStringArrayExtra("designation");
        String[] mobileno = intent.getStringArrayExtra("mobileno");
        String[] emailid = intent.getStringArrayExtra("emailid");
        String club_infotext = intent.getStringExtra("clubinfo");

        mainimage.setImageDrawable(getResources().getDrawable(clublogo_address));
        main_info_lbl.setText(club_infotext);


        ArrayList<String> arraylist = intent.getStringArrayListExtra("imglist");

        List<CarouselItem> list = new ArrayList<>();

        for(int i=0; i<arraylist.size(); i++){
            list.add(new CarouselItem(arraylist.get(i)));
        }
        carousel.setData(list);

        add_data_to_people_list(name, designation, mobileno, emailid);


        if(insta == null || insta.equals(".")){
            insta_img.setVisibility(View.GONE);
        } else {
            insta_img.setVisibility(View.VISIBLE);
        }

        if(gmail == null || gmail.equals(".")){
            gmail_img.setVisibility(View.GONE);
        } else {
            gmail_img.setVisibility(View.VISIBLE);
        }

        if(youtube == null || youtube.equals(".")){
            youtube_img.setVisibility(View.GONE);
        } else {
            youtube_img.setVisibility(View.VISIBLE);
        }

        if((insta == null || insta.equals(".")) && (gmail == null || gmail.equals(".")) && (youtube == null || youtube.equals("."))){
            findViewById(R.id.insideclubfest_connect_txt).setVisibility(View.GONE);
        }

        insta_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(insta != null) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(insta));
                    startActivity(browserIntent);
                }
            }
        });

        gmail_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gmail != null) {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:" + gmail));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "");
                    intent.putExtra(Intent.EXTRA_TEXT, "");
                    startActivity(intent);
                }
            }
        });

        youtube_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(youtube != null) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(youtube));
                    startActivity(browserIntent);
                }
            }
        });
    }


    private void add_data_to_people_list(String[] name, String[] designation, String[] mobileno, String[] emailid) {
        people_info_adapter adapter = new people_info_adapter(inside_club_fest_gymkhana.this, name, designation, mobileno, emailid);
        personlist.setAdapter(adapter);
        ListViewUtil.setListViewHeightBasedOnChildren(personlist);
    }

    public class people_info_adapter extends ArrayAdapter<String> {
        String[] mName;
        String[] mDesignation;
        String[] mMobileno;
        String[] mEmailid;
        Context mContext;

        public people_info_adapter(Context context, String[] arName, String[] arDesignation, String[] arMobileno, String[] arEmailid) {
            super(context, R.layout.person_card_contactinfo, R.id.personname, arName);

            mName = arName;
            mDesignation = arDesignation;
            mMobileno = arMobileno;
            mEmailid = arEmailid;
            mContext = context;

        }


        @SuppressLint("ResourceAsColor")
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View row = convertView;
            VHolder_person_info vholder;

            if (row == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.person_card_contactinfo, parent, false);

                vholder = new VHolder_person_info(row);
                row.setTag(vholder);
            } else {
                vholder = (VHolder_person_info) row.getTag();
            }


            vholder.txtName.setText(mName[position]);
            vholder.txtDesignation.setText(mDesignation[position]);

            vholder.phone_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + mMobileno[position]));
                    startActivity(intent);
                }
            });

            vholder.mail_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:" + mEmailid[position]));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "");
                    intent.putExtra(Intent.EXTRA_TEXT, "");
                    startActivity(intent);
                }
            });

            return row;
        }
    }

    public class VHolder_person_info {
        TextView txtName, txtDesignation;
        ImageView phone_img, mail_img;

        public VHolder_person_info(View r) {
            txtName = r.findViewById(R.id.personname);
            txtDesignation = r.findViewById(R.id.person_designation);
            phone_img = r.findViewById(R.id.call_img);
            mail_img = r.findViewById(R.id.mail_img);
        }

    }
}