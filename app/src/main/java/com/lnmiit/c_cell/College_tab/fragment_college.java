package com.lnmiit.c_cell.College_tab;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lnmiit.c_cell.PDF_display;
import com.lnmiit.c_cell.R;


public class fragment_college extends Fragment {

    CardView holidaycalendar_card, bustimetable_card, messmenu_card, sop_card,
            impcontacts_card, hod_card, headsection_card, hostelcontacts_card, campusmap_card,
            acadmap_card, curriculum_card, implinks_card;
    TextView direct_message_para1_lbl, direct_message_para2_lbl;

    String directormessage2 = "The Institute, in spite of being young (founded in 2002, jointly by the Government of Rajasthan and the Lakshmi & Usha Mittal Foundation in the public-private partnership mode) is considered as one of the best institutions in its chosen areas of higher learning, both in the state and the country. In addition to having been accredited by the National Assessment & Accreditation Council (NAAC) as an ‘A’ grade institution, the LNMIIT has been ranked fairly high by many different agencies in the recent past as may be noticed elsewhere on the official web-portal.\n" +
            "\n" +
            "The Institute takes pride in its eco-system that aims to groom incoming students into academically strong yet well-rounded personality based professionals who could adapt themselves to the challenges posed by the ever-changing world and working environments.\n" +
            "\n" +
            "If you are an aspiring student, we welcome you to take a good look at our website to know more about what the Institute has to offer and preferably consider visiting the campus for getting to know it even better by getting the first hand feel of its ambience and interacting with faculty and students so that you could take a well-informed decision.\n" +
            "\n" +
            "If you have already applied to the LNMIIT, have been offered an admission and accepted the offer, Congratulations and Welcome to this new home of yours for next few years!";
    String directormessage1 = "Welcome to The LNM Institute of Information Technology (LNMIIT), Jaipur! The LNMIIT is an institution of higher learning focused in select areas of Computing, Communication, ICT, Electronics and carefully chosen traditional engineering and sciences with an innovative blend of interdisciplinary flavor and contemporary relevance.";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_college, container, false);

        holidaycalendar_card = v.findViewById(R.id.fragment_college_holidaycal_card);
        bustimetable_card = v.findViewById(R.id.fragment_college_bustimetable_card);
        messmenu_card = v.findViewById(R.id.fragment_college_messmenu_card);
        sop_card = v.findViewById(R.id.fragment_college_sop_card);
        impcontacts_card = v.findViewById(R.id.fragment_college_impcontacts_card);
        hod_card = v.findViewById(R.id.fragment_college_hods_card);
        headsection_card = v.findViewById(R.id.fragment_college_headsection_card);
        hostelcontacts_card = v.findViewById(R.id.fragment_college_hostelcontacts_card);
        campusmap_card = v.findViewById(R.id.fragment_college_campusmap_card);
        acadmap_card = v.findViewById(R.id.fragment_college_acadmap_card);
        curriculum_card = v.findViewById(R.id.fragment_college_curriculum_card);
        implinks_card = v.findViewById(R.id.fragment_college_implinks_card);
        direct_message_para1_lbl = v.findViewById(R.id.frag_college_director_message_para1);
        direct_message_para2_lbl = v.findViewById(R.id.frag_college_director_message_para2);

        direct_message_para1_lbl.setText(directormessage1);
        direct_message_para2_lbl.setText(directormessage2);

        set_click_lisners_for_pdfs();


        impcontacts_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Contacts_display.class);
                intent.putExtra("operation", 0);
                startActivity(intent);
            }
        });

        hod_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Contacts_display.class);
                intent.putExtra("operation", 1);
                startActivity(intent);
            }
        });

        headsection_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Contacts_display.class);
                intent.putExtra("operation", 2);
                startActivity(intent);
            }
        });

        hostelcontacts_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Contacts_display.class);
                intent.putExtra("operation", 3);
                startActivity(intent);
            }
        });

        curriculum_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Curriculum_subjects.class));
            }
        });

        implinks_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), important_links.class));
            }
        });


        return v;
    }

    private void set_click_lisners_for_pdfs() {
        holidaycalendar_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PDF_display.class);
                intent.putExtra("pdfUrl", "https://drive.google.com/file/d/1xapw_p19zfN0rUFlBwme07kHWcE0VlUS/view?usp=drive_link");
                intent.putExtra("operation", 0);
                startActivity(intent);
            }
        });

        bustimetable_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PDF_display.class);
                intent.putExtra("pdfUrl", "https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/pdf/Bus_Time_Table.pdf?raw=true");
                intent.putExtra("operation", 1);
                startActivity(intent);
            }
        });

        messmenu_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PDF_display.class);
                intent.putExtra("pdfUrl", "https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/pdf/Mess_Menu.pdf?raw=true");
                intent.putExtra("operation", 1);
                startActivity(intent);
            }
        });

        sop_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PDF_display.class);
                intent.putExtra("pdfUrl", "https://drive.google.com/file/d/1tLYIWIWherLYL6s03uSfTPyEtk-hvi6M/view?usp=sharing");
                intent.putExtra("operation", 0);
                startActivity(intent);
            }
        });

        campusmap_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PDF_display.class);
                intent.putExtra("pdfUrl", "https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/pdf/CampusAreamap.pdf?raw=true");
                intent.putExtra("operation", 1);
                startActivity(intent);
            }
        });

        acadmap_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PDF_display.class);
                intent.putExtra("pdfUrl", "https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/pdf/AcadsAreamap.pdf?raw=true");
                intent.putExtra("operation", 1);
                startActivity(intent);
            }
        });
    }
}