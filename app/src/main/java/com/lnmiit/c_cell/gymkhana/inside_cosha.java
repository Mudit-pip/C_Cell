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

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.lnmiit.c_cell.ListViewUtil;
import com.lnmiit.c_cell.R;

public class inside_cosha extends AppCompatActivity {

    ListView personlist;
    TextView main_info_lbl;
    CardView canteen_card, hostel_card, mess_card;
    String maintext = "A college is composed of many things: students, professors, academic blocks, hostels, mess etc. For the proper functioning of everything lying beneath the biosphere of Hostels, Mess and Canteen, Committee of Students for Hostel Affairs (COSHA) is the way to go. COSHA supervises all matters of common interest to the Hostels, whilst handling queries, complaints and suggestions regarding Mess and Canteen. Be it improving the mess menu, lodging a complaint regarding canteen shops, or raising a query related to the habitable conditions of hostels; Cosha is inculcated with the responsibility of being the voice of students and relaying their valid concerns to the higher authorities. A meeting of COSHA is chaired by the President, and consists of the Convenor of COSHA, Hall Representatives and Chief Warden/Wardens. In a meeting, COSHA puts forward the students’ candid views and tries to establish a common ground. COSHA believes in eliminating all complaints, relaying constructive suggestions and maintaining transparency at all fronts.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_insite_cosha);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        main_info_lbl = findViewById(R.id.cosha_info_lbl);
        personlist = findViewById(R.id.inside_cosha_peopleinfo_list);
        canteen_card = findViewById(R.id.cosha_canteen);
        hostel_card = findViewById(R.id.cosha_hostel);
        mess_card = findViewById(R.id.cosha_mess);


        main_info_lbl.setText(maintext);

        add_data_to_people_list();

    }

    private void add_data_to_people_list() {
        String[] name = {"Mr. Aman Manish Agrawal"};
        String[] designation = {"CoSHA Head"};
        String[] mobileno = {"8983307255"};
        String[] emailid = {"cosha@lnmiit.ac.in"};

        people_info_adapter adapter = new people_info_adapter(inside_cosha.this, name, designation, mobileno, emailid);
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