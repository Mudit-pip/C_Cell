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

import com.lnmiit.c_cell.R;

public class Contacts_display extends AppCompatActivity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contacts_display);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        list = findViewById(R.id.college_contacts_display_listview);

        Intent intent = getIntent();
        int operation = intent.getIntExtra("operation", 0);

        add_data_to_people_list(operation);
    }

    private void add_data_to_people_list(int op) {
        String[] name;
        String[] designation;
        String[] mobileno;
        String[] emailid;

//        op == 0 means Important Contacts
//        op == 1 means HOD's
//        op == 2 means Head of Sections
//        op == 3 means Hostel Contacts
        if (op == 0) {
            name = new String[]{"Rahul Banerjee",
                    "Dr. Nikhil Sharma",
                    "Mr. Rajeev Saxena",
                    "Mr. Devaram Rabari",
                    "Mr. Samar Singh", "Dr. Chand Singh Panwar"};
            designation = new String[]{"Director",
                    "Assistant Dean of Academic Affairs",
                    "Assistant Registrar - Academic",
                    "Finance Assistant",
                    "Assistant Registrar", "Resident Doctor"};
            mobileno = new String[]{"3526002",
                    "3526012",
                    "3526051",
                    "3526102",
                    "3526132", "3526100"};
            emailid = new String[]{".", ".", ".", ".", ".", "."};
        } else if (op == 1) {
            name = new String[]{"Dr. Jayprakash Kar", "Dr. Sunil kumar", "Dr. Nikhil Sharma", "Dr. Mohit Makkar", "Dr. Ashok Garai", "Dr. Manish Garg", "Dr. Surinder Singh Nehra"};
            designation = new String[]{"CSE", "CCE", "ECE", "Mechanical", "Physics", "Mathematics", "Humanities and Social Sciences"};
            mobileno = new String[]{"0141-3526212", "0141-3526227", "0141-3526318", "0141-3526360", "0141-3526387", "0141-3526269", "0141-3526294"};
            emailid = new String[]{"jayaprakashkar@lnmiit.ac.in", "sunil@lnmiit.ac.in", "nikhil.sharma@lnmiit.ac.in", "mohit.makkar@lnmiit.ac.in", "ashok.garai@lnmiit.ac.in", "manishgarg@lnmiit.ac.on", "surinder.nehra@lnmiit.ac.in"};
        } else if (op == 2) {
            name = new String[]{"Ashok Kumar Salecha", "Ajeet Singh Rawat", "Raghuveer Singh Charan"};
            designation = new String[]{"Finance and Purchase Officer", "Assistant Registrar", "Sports Officer"};
            mobileno = new String[]{"0141-3526101", "0141-3526032", "0141-3526136"};
            emailid = new String[]{"finance@lnmiit.ac.in", "ajeetsinghrawat@lnmiit.ac.in", "raghuveersingh@lnmiit.ac.in"};
        } else {
            name = new String[]{"Dr Kanjalochan Jena", "Dr Servesh Agnihotri", "Dr. Poonam Gera", " Mrs. Madhu Yadhav", "Mrs. Sakshi Sharma", "Mrs. Pankesh Sharma", "Mrs. Manju Kunwar", "Mr. Namo Narayan Meena", "Mr. Prahlad Sharma ", "Mr. Abhishek Sharma", "Mr. Kajor Meena", "Mr. Namo Narayan Meena", "Mr. Kamlesh Kumar Meena", "Mr. Suresh chand Danka", "Mr. Rahul Sharma", "Mr. Ram kumar Singh", "Mr. Madhu Sudan Sharma", "Mr. Ghanshyam Sharma", "Mr. Praveen Kumar Jha", "Mr. Manoj Kumar Pancholi"};
            designation = new String[]{"Chief warden", "Associate Chief Warden(bh)", "warden-girls hostel", "Jr. Hostel Superintendent GH", "Hostel Support GH", "Hostel Support GH", "Hostel Support GH", "Jr. Hostel Superintendent BH1", "Hostel Support BH1", "Hostel Support BH1", "Hostel Support BH1", "Jr. Hostel Superintendent BH2", "Hostel Support BH2", "Hostel Support BH2", "Hostel Support BH3", "Hostel Support BH3", "Hostel Support BH3", "Jr. Hostel Superintendent BH4", "Hostel Support BH4", "Hostel Support BH4"};
            mobileno = new String[]{"0141-3526314", "0141-3526391", "0141-3526225", "91-141-3526158", "91-141-3526158", "91-141-3526158", "91-141-3526158", "91-141-3526145", "91-141-3526145", "91-141-3526145", "91-141-3526145", "91-141-3526148", "91-141-3526148", "91-141-3526148", "91-141-3526151", "91-141-3526151", "91-141-3526151", "91-141-3526153", "91-141-3526153", "91-141-3526153"};
            emailid = new String[]{"chief-wardan@lnmiit.ac.in", "assoc.cw@lnmiit.ac.in", "warden-gh@lnmiit.ac.in", "jhs-gh@lnmiit.ac.in", "gh-support@lnmiit.ac.in", "gh-support@lnmiit.ac.in", "gh-support@lnmiit.ac.in", "jhs-bh1@lnmiit.ac.in", "bh1-support@lnmiit.ac.in", "bh1-support@lnmiit.ac.in", "bh1-support@lnmiit.ac.in", "jhs-bh2@lnmiit.ac.in", "bh2-support@lnmiit.ac.in", "bh2-support@lnmiit.ac.in", "bh3-support@lnmiit.ac.in", "bh3-support@lnmiit.ac.in", "bh3-support@lnmiit.ac.in", "jhs-bh3@lnmiit.ac.in", "bh4-support@lnmiit.ac.in", "bh4-support@lnmiit.ac.in"};
        }

        people_info_adapter adapter = new people_info_adapter(Contacts_display.this, name, designation, mobileno, emailid);
        list.setAdapter(adapter);
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

            if(mEmailid[position].equals(".")){
                vholder.mail_img.setVisibility(View.GONE);
            } else {
                vholder.mail_img.setVisibility(View.VISIBLE);
            }

            vholder.mail_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vholder.mail_img.setVisibility(View.VISIBLE);
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