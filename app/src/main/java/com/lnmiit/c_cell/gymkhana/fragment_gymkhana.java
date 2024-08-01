package com.lnmiit.c_cell.gymkhana;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.lnmiit.c_cell.ListViewUtil;
import com.lnmiit.c_cell.R;

import java.util.ArrayList;


public class fragment_gymkhana extends Fragment {

    //changeable info
    String gymkhana_info = "Every college works on the efforts that its student masses put in it to make the college for the students, of the students, and by the students. The LNMIIT Students’ Gymkhana, under the Director of the Institute's patronage, acts as a communication service and facilitates decision-making in the greater interest of the students on The LNMIIT.";

    int[] mImg = {R.drawable.vivacity_logo, R.drawable.plinth_logo, R.drawable.despo_logo, R.drawable.tedlnmiit_logo, R.drawable.esubmit_logo};
    ///////////////////
    TextView gymkhana_info_txt;
    ListView person_info_list;
    GridView councils_info_grid, fests_info_grid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_gymkhana, container, false);

        person_info_list = v.findViewById(R.id.frag_gymkhana_peopleinfo_list);
        councils_info_grid = v.findViewById(R.id.frag_gymkhana_councils_grid);
        fests_info_grid = v.findViewById(R.id.frag_gymkhana_fests_grid);
        gymkhana_info_txt = v.findViewById(R.id.frag_gymkhana_info);

        gymkhana_info_txt.setText(gymkhana_info);

        add_data_to_people_list();
        add_data_to_council_info();
        add_data_to_fests_info();

        councils_info_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 3) {
                    Intent intent = new Intent(getContext(), inside_cosha.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getContext(), inside_council_gymkhana.class);
                    intent.putExtra("id", position);
                    startActivity(intent);
                }
            }
        });

        fests_info_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), inside_club_fest_gymkhana.class);
                intent.putExtra("club_img", mImg[position]);
                ArrayList<String> list = new ArrayList<>();
                String[] name, designation, mobileno, emailid;
                String clubinfo = "";

                if (position == 0) {
                    //vivacity
                    clubinfo = "Vivacity in its existence stood to justify itself as one of the liveliest and most animated jubilations that youth has ever experienced. Embarked upon in 2007, today the cultural management festival has snowballed to the popularity of gigantic proportions, all of which can be attributed to the acuminous student committee that has piloted this fest in its odyssey so far. It juxtaposes several dances, music, dramatics, literature, and fashion events with informal fun events, authorized workshops, exhibitions, and gaming challenges. The brimming talents judged by distinguished virtuosos contend their way to winning titanic prizes.";
                    name = new String[]{"Ajay Raj Singh Shekhawat", "Prathmesh Ranjan"};
                    designation = new String[]{"Head", "Head"};
                    mobileno = new String[]{"8529528101", "7007175380"};
                    emailid = new String[]{"21ucc121@lnmiit.ac.in", "21uec101@lnmiit.ac.in"};

                    list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/FestImages/VIVACITY/v1.jpg?raw=true");
                    list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/FestImages/VIVACITY/v2.jpg?raw=true");
                    list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/FestImages/VIVACITY/v3.jpg?raw=true");
                    list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/FestImages/VIVACITY/v4.jpg?raw=true");
                    list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/FestImages/VIVACITY/v5.png?raw=true");

                    intent.putExtra("insta", "https://www.instagram.com/vivacity_lnmiit?igsh=anNmYXU5aWFucmNw");
                    intent.putExtra("gmail", "vivacity@lnmiit.ac.in");
                    intent.putExtra("youtube", "https://youtube.com/@vivacitylnmiit?si=9fYlDaPBjciGFxvE");
                } else if (position == 1) {
                    //plinth
                    clubinfo = "PLINTH is the annual Techno-Management Literary fest of The LNMIIT. It is one of the exquisite platforms which help students plunge bring out the creativity skills and for all to witness one of the most beautiful and breath-taking amalgamations PLINTH organizes various events related to ROBOTIX, CYBERNETRIX, Literature and Business. Plinth for the past years has served to be the ideal destination for the millennials to learn, create and experience the beauty of technology. It proudly encompasses and transcends the boundaries of science and technology, providing its audience a completely indelible experience. This festival comprises of a plethora of events as well as talks by eminent personalities in the field of science, technology and management. A wide range of competitions in diverse fields besides exhibitions, workshops and fun challenges tempt a really big number of participants from across the length and breadth of the country. In a nutshell, PLINTH 2023 promises to keep participants from all walks and tastes occupied for an awe-in-spring and absolutely overwhelming. 2-day experience.";
                    name = new String[]{"Yug Agarwal", "Rajat Sharma"};
                    designation = new String[]{"Head", "Head"};
                    mobileno = new String[]{"8299099721", "8972192855"};
                    emailid = new String[]{"22ucs233@lnmiit.ac.in", "22uec106@lnmiit.ac.in"};


                    list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/FestImages/PLINTH/p1.jpg?raw=true");
                    list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/FestImages/PLINTH/p2.jpg?raw=true");
                    list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/FestImages/PLINTH/p3.jpg?raw=true");
                    list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/FestImages/PLINTH/p4.jpg?raw=true");
                    list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/FestImages/PLINTH/p5.jpg?raw=true");
                    list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/FestImages/PLINTH/p6.jpg?raw=true");
                    list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/FestImages/PLINTH/p7.jpg?raw=true");
                    list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/FestImages/PLINTH/p8.jpg?raw=true");
                    list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/FestImages/PLINTH/p9.jpg?raw=true");
                    list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/FestImages/PLINTH/p10.jpg?raw=true");
                    list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/FestImages/PLINTH/p11.jpg?raw=true");


                    intent.putExtra("insta", "https://www.instagram.com/plinth.lnmiit?igsh=MTl5dXYyamt2eWp6NQ%3D%3D");
                    intent.putExtra("gmail", "plinth@lnmiit.ac.in");
                    intent.putExtra("youtube", "https://youtube.com/@plinth.lnmiit?si=2IlodGRGZStr3aWg");
                } else if (position == 2) {
                    //despo
                    clubinfo = "Desportivos is the annual sports festival of LNMIIT Jaipur organized by the Sports Council. It is the most prestigious and largest sports meet in Rajasthan. It attracts a broad spectrum of students from all over the country to showcase their talents and facilitate cross-cultural learning experiences. The fest aims for its students to appreciate our culture's unity and develop a spirit for sports. Desportivos spans for three days that witnesses a multitude of academic and technically oriented students remodel into sports fanatics. The festival incorporates a wide range of outdoor and indoor sports activities like cricket, badminton, volleyball, basketball, football, table tennis, chess, carom, etc. The fest has been a great success with the participation of over 105 colleges and the footfall of more than 3000 students. Enthusiasm and sportsmanship are the key elements that make Desportivos an enthralling experience.";
                    name = new String[]{"Ankur Chandel", "Deepak Dayma"};
                    designation = new String[]{"Head", "Head"};
                    mobileno = new String[]{"9571193432", "8149491613"};
                    emailid = new String[]{"21ucs020@lnmiit.ac.in", "21ucs055@lnmiit.ac.in"};


//                    list.add("?raw=true");

                    intent.putExtra("insta", "https://www.instagram.com/mediacell_lnmiit/");
                    intent.putExtra("gmail", "mediacell@lnmiit.ac.in");
                    intent.putExtra("youtube", "https://www.youtube.com/@mediacell-lnmiit");
                } else if (position == 3) {
                    //tedx
                    clubinfo = "TEDxLNMIIT is an independently organized TED event that brings the spirit of TED’s mission, “ideas worth spreading,” to our college. TEDxLNMIIT provides a platform for the community to share inspiring and thought-provoking ideas across various fields such as science, technology, art, and education. It's an event where speakers from diverse backgrounds come together to spark conversations, challenge conventional wisdom, and inspire innovative thinking.\n" +
                            "TEDxLNMIIT'24 was organized on January 13, 2024. The theme for the event was “Bending the Basics”. This event focused on challenging conventional wisdom, reimagining fundamentals, and pushing boundaries to create new possibilities. The speakers were: Gunjan Saini, Dr. Tanu Jain, Chinmay Gaur, Deepak Pareek, Tejas Patil, Palakh Khanna, Sakshi Mandhyan, and Krishnan Sunderarajan.";
                    name = new String[]{"Abhinav Singh", "Suhani Gupta", "Abhey Raheja", "Krishna Rohira"};
                    designation = new String[]{"Coordinator", "Coordinator", "Coordinator", "Coordinator"};
                    mobileno = new String[]{"9643271207", "9636784450", "6280407479", "7727077033"};
                    emailid = new String[]{"22ucs004@lnmiit.ac.in", "22uec137@lnmiit.ac.in", "22ucs003@lnmiit.ac.in", "22ume018@lnmiit.ac.in"};

                    list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/FestImages/TEDx/t1.jpg?raw=true");
                    list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/FestImages/TEDx/t2.jpg?raw=true");
                    list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/FestImages/TEDx/t3.jpg?raw=true");
                    list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/FestImages/TEDx/t4.jpg?raw=true");
                    list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/FestImages/TEDx/t5.jpg?raw=true");

                    intent.putExtra("insta", "https://www.instagram.com/rendition_lnmiit/?img_index=1");
                    intent.putExtra("gmail", "rendition@lnmiit.ac.in");
                    intent.putExtra("youtube", "https://www.youtube.com/@Rendition.lnmiit");
                } else {
                    //esubmit
                    clubinfo = "E-Summit is a three-day event, started as an initiative for young entrepreneurs across the country. The Summit is more than just a platform for entrepreneurs and funding agencies to interact-it's a nexus for establishing connections among experienced and emerging startups led by the bright minds from participating institutes nationwide, seamlessly bridging the worlds of academia and industry stakeholders." +
                            "\n"+
                            "With E-summit, we envision to elevate the spirit of young entrepreneurs. To unleash the latent entrepreneurial talent within everyone and to bridge the student community and industry veterans. It is the stage for future Industry leaders to showcase and refine their skills.";

                    name = new String[]{"Dishant Jain", "Aashrith Boppudi"};
                    designation = new String[]{"Coordinator", "Coordinator"};
                    mobileno = new String[]{"8200421291", "6302713914"};
                    emailid = new String[]{"22ucs068@lnmiit.ac.in", "22ucs051@lnmiit.ac.in"};

                    list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/FestImages/Esubmit/ne1.png?raw=true");
                    list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/FestImages/Esubmit/ne2.png?raw=true");
                    list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/FestImages/Esubmit/ne3.png?raw=true");
                    list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/FestImages/Esubmit/ne4.png?raw=true");
                    list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/FestImages/Esubmit/ne5.png?raw=true");
                    list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/FestImages/Esubmit/ne6.png?raw=true");
                    list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/FestImages/Esubmit/ne7.png?raw=true");

                    intent.putExtra("insta", "https://www.instagram.com/insignia_lnm?igsh=MXgweWkxdmx5OG9lbg==");
                    intent.putExtra("gmail", "insignia@lnmiit.ac.in");
                    intent.putExtra("youtube", "https://www.youtube.com/@insignia6397");
                }

                intent.putStringArrayListExtra("imglist", list);
                intent.putExtra("name", name);
                intent.putExtra("designation", designation);
                intent.putExtra("mobileno", mobileno);
                intent.putExtra("emailid", emailid);
                intent.putExtra("clubinfo", clubinfo);


                startActivity(intent);
            }
        });
        return v;
    }

    private void add_data_to_fests_info() {
        String[] title = {"Vivacity", "Plinth", "Desportivos", "TEDxLNMIIT", "E-Summit"};
        int[] img = {R.drawable.vivacity_logo, R.drawable.plinth_logo, R.drawable.despo_logo, R.drawable.tedlnmiit_logo, R.drawable.esubmit_logo};
        int[] color = {R.color.custom_tile_orange, R.color.custom_tile_purple, R.color.custom_tile_blue, R.color.custom_tile_red, R.color.custom_tile_orange};

        card_adapter adapter = new card_adapter(getContext(), title, color, img);
        fests_info_grid.setAdapter(adapter);
        ListViewUtil.setGridViewHeightBasedOnChildren(fests_info_grid, 2);
    }

    private void add_data_to_council_info() {
        String[] title = {"Cultural Council", "Science & Technology Council", "Sports Council", "COSHA Committee"};
        int[] img = {R.drawable.cultural_council, R.drawable.scitech_council, R.drawable.sports_council, R.drawable.cosha};
        int[] color = {R.color.custom_tile_orange, R.color.custom_tile_purple, R.color.custom_tile_blue, R.color.custom_tile_red};

        card_adapter adapter = new card_adapter(getContext(), title, color, img);
        councils_info_grid.setAdapter(adapter);
        ListViewUtil.setGridViewHeightBasedOnChildren(councils_info_grid, 2);
    }


    private void add_data_to_people_list() {
        String[] name = {"Mr. Vaibhav Khamesra", "Mr. Ashish Goyal", "Mr. Saransh Jindal"};
        String[] designation = {"President", "Vise-President", "Finance Convener"};
        String[] mobileno = {"7023659757", "6377079159", "8851625921"};
        String[] emailid = {"gym.president@lnmiit.ac.in", "ggym.vicepresident@lnmiit.ac.in", "gym.financeconvenor@lnmiit.ac.in"};

        people_info_adapter adapter = new people_info_adapter(getContext(), name, designation, mobileno, emailid);
        person_info_list.setAdapter(adapter);
        ListViewUtil.setListViewHeightBasedOnChildren(person_info_list);
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


    public class card_adapter extends ArrayAdapter<String> {
        String[] mTitle;
        int[] mColor;
        int[] mImg;
        Context mContext;

        public card_adapter(Context context, String[] arTitle, int[] arColor, int[] arImg) {
            super(context, R.layout.img_text_card, R.id.imgcard_title, arTitle);

            mTitle = arTitle;
            mColor = arColor;
            mImg = arImg;
            mContext = context;

        }


        @SuppressLint("ResourceAsColor")
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View row = convertView;
            VHolder_card vholder;

            if (row == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.img_text_card, parent, false);

                vholder = new VHolder_card(row);
                row.setTag(vholder);
            } else {
                vholder = (VHolder_card) row.getTag();
            }

            vholder.logo.setImageDrawable(getResources().getDrawable(mImg[position]));
            vholder.txtTitle.setText(mTitle[position]);
            vholder.card.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(mContext, mColor[position])));

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


    public class VHolder_card {
        TextView txtTitle;
        CardView card;
        ImageView logo;

        public VHolder_card(View r) {
            txtTitle = r.findViewById(R.id.imgcard_title);
            card = r.findViewById(R.id.imgcard_card);
            logo = r.findViewById(R.id.imgcard_image);
        }

    }
}