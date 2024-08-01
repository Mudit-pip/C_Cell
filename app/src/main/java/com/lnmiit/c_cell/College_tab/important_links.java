package com.lnmiit.c_cell.College_tab;

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

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.lnmiit.c_cell.ListViewUtil;
import com.lnmiit.c_cell.R;

public class important_links extends AppCompatActivity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_important_links);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        list = findViewById(R.id.college_implinks_listview);

        add_data_to_websitelist();
    }

    private void add_data_to_websitelist() {
        String[] name = {"LNMIIT Official Website", "Scholarship Policy", "Fee Structure - UG Admissions", "Training and Placement Cell", "MIS Portal", "Moodle LNMIIT"};
        String[] link = {"https://www.lnmiit.ac.in/", "https://lnmiit.ac.in/admissions/ug/regular-mode/#:~:text=Academic%20performance%20at%20LNMIIT%20(CGPA,to%20INR%2030000%20per%20semester.", "https://lnmiit.ac.in/admissions/ug/regular-mode/", "https://placements.lnmiit.ac.in/", "https://erp.lnmiit.ac.in/mis/", "https://moodle.lnmiit.ac.in/moodle/"};

        people_info_adapter adapter = new people_info_adapter(important_links.this, name, link);
        list.setAdapter(adapter);
        ListViewUtil.setListViewHeightBasedOnChildren(list);
    }


    public class people_info_adapter extends ArrayAdapter<String> {
        String[] mName;
        String[] mLink;
        Context mContext;

        public people_info_adapter(Context context, String[] arName, String[] arLink) {
            super(context, R.layout.website_card, R.id.website_name, arName);
            mName = arName;
            mLink = arLink;
            mContext = context;
        }


        @SuppressLint("ResourceAsColor")
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View row = convertView;
            VHolder_website vholder;

            if (row == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.website_card, parent, false);

                vholder = new VHolder_website(row);
                row.setTag(vholder);
            } else {
                vholder = (VHolder_website) row.getTag();
            }


            vholder.txtName.setText(mName[position]);
            vholder.website_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mLink[position]));
                    startActivity(browserIntent);
                }
            });

            return row;
        }
    }


    public class VHolder_website {
        TextView txtName;
        ImageView website_img;

        public VHolder_website(View r) {
            txtName = r.findViewById(R.id.website_name);
            website_img = r.findViewById(R.id.webpage_img);
        }

    }
}