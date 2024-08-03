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
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.lnmiit.c_cell.ListViewUtil;
import com.lnmiit.c_cell.R;

import java.util.ArrayList;

public class inside_council_gymkhana extends AppCompatActivity {

    ListView person_info_list;
    GridView clubs_grid;
    ImageView mainimg;
    TextView maintxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inside_council_gymkhana);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        person_info_list = findViewById(R.id.inside_council_peopleinfo_list);
        clubs_grid = findViewById(R.id.insidecouncil_clubs_grid);
        mainimg = findViewById(R.id.inside_council_main_image);
        maintxt = findViewById(R.id.inside_council_club_info_lbl);


        int id = getIntent().getIntExtra("id", 0);
        //id
        //0 = cultural council
        //1 = science and technology council
        //2 = sports council
        if (id == 0) {
            mainimg.setImageDrawable(getResources().getDrawable(R.drawable.cultural_council));
            maintxt.setText("The Cultural Society of LNMIIT keeps the vibe and enthusiasm alive on the campus. It is a student body responsible for all the cultural events in the institute around the year. It is the functional body for organizing a plethora of events, club activities, and workshops throughout the year.");
        } else if (id == 1) {
            mainimg.setImageDrawable(getResources().getDrawable(R.drawable.scitech_council));
            maintxt.setText("The Council concentrates on imparting students with knowledge that is beyond the academic curriculum. It aims at stimulating the technical mindset of the students and carries out activities like Workshops, Competitions and Recreational events to provide all students with hands-on experience as well as practical knowledge through the clubs. The Council thus believes that student organizations are a great way for a student to meet new people, broaden their knowledge and skills, and enrich their college experience.");
        } else {
            mainimg.setImageDrawable(getResources().getDrawable(R.drawable.sports_council));
            maintxt.setText("he LNMIIT Sports Council works towards instilling a subtle sports culture among students by organizing and promoting various outdoor and indoor sport events. The council is responsible for all the decision making involving the sports inventory of the institute. Various events are organized throughout the year which includes, LNMIIT Premier League, LNMIIT Football League, LNMIIT Volleyball League. Inter-year and inter-hostel tournaments are also organized to boost unanimity via the means of sports.");
        }

        add_data_to_people_list(id);
        add_data_to_clubs_info(id);
    }

    private void add_data_to_clubs_info(int id) {
        String[] title;
        int[] img, tilecolor, txtcolor;

        //0 = cultural council
        //1 = science and technology council
        //2 = sports council
        if (id == 0) {
            title = new String[]{"AAVEG, The Nukkad Mandali", "Media Cell", "Rendition, The Dramatics Club", "Insignia, The Dance Club", "Capriccio, The Music Club", "Imagination", "Sankalp Club", "Vignette, The Art Club", "Eminence, The Fashion Club", "Fundoo Club", "Literary Committee"};
            img = new int[]{R.drawable.aaveg_logo, R.drawable.mediacell_logo, R.drawable.rendition_logo, R.drawable.insignia_logo, R.drawable.capriccio_logo, R.drawable.imagi_logo, R.drawable.sankalp_logo, R.drawable.vignette_logo, R.drawable.eminence_logo, R.drawable.fundoo_logo, R.drawable.lc_logo};
            tilecolor = new int[]{R.color.custom_tile_orange, R.color.custom_tile_purple, R.color.custom_tile_blue, R.color.custom_tile_red, R.color.custom_tile_orange, R.color.custom_tile_purple, R.color.custom_tile_blue, R.color.custom_tile_red, R.color.custom_tile_orange, R.color.custom_tile_purple, R.color.custom_tile_blue};
            txtcolor = new int[]{R.color.custom_text_orange, R.color.custom_text_purple, R.color.custom_text_blue, R.color.custom_text_red, R.color.custom_text_orange, R.color.custom_text_purple, R.color.custom_text_blue, R.color.custom_text_red, R.color.custom_text_orange, R.color.custom_text_purple, R.color.custom_text_blue};
        } else if (id == 1) {
            title = new String[]{"Astronomy", "Cipher", "Debsoc", "Phoenix", "Cybros", "Quizzinga", "E Cell"};
            img = new int[]{R.drawable.astro_logo, R.drawable.cipher_logo, R.drawable.debsoc_logo, R.drawable.phoenix_logo, R.drawable.cybros_logo, R.drawable.quizzinga_logo, R.drawable.ecell_logo};
            tilecolor = new int[]{R.color.custom_tile_orange, R.color.custom_tile_purple, R.color.custom_tile_blue, R.color.custom_tile_red, R.color.custom_tile_orange, R.color.custom_tile_purple, R.color.custom_tile_blue};
            txtcolor = new int[]{R.color.custom_text_orange, R.color.custom_text_purple, R.color.custom_text_blue, R.color.custom_text_red, R.color.custom_text_orange, R.color.custom_text_purple, R.color.custom_text_blue};
        } else {
            title = new String[]{"Badminton", "Chess", "Volleyball", "Cricket", "Basketball", "Football", "Kabaddi", "Lawn Tennis", "Table Tennis", "Squash"};
            img = new int[]{R.drawable.badminton_logo, R.drawable.chess_logo, R.drawable.vollyball_logo, R.drawable.circket_logo, R.drawable.basketball_logo, R.drawable.football_logo, R.drawable.kabaddi_logo, R.drawable.lawntennis_logo, R.drawable.tabletennis_logo, R.drawable.squash_logo};
            tilecolor = new int[]{R.color.custom_tile_orange, R.color.custom_tile_purple, R.color.custom_tile_blue, R.color.custom_tile_red, R.color.custom_tile_orange, R.color.custom_tile_purple, R.color.custom_tile_blue, R.color.custom_tile_red, R.color.custom_tile_orange, R.color.custom_tile_purple};
            txtcolor = new int[]{R.color.custom_text_orange, R.color.custom_text_purple, R.color.custom_text_blue, R.color.custom_text_red, R.color.custom_text_orange, R.color.custom_text_purple, R.color.custom_text_blue, R.color.custom_text_red, R.color.custom_text_orange, R.color.custom_text_purple};
        }
        card_adapter adapter = new card_adapter(inside_council_gymkhana.this, title, tilecolor, img, txtcolor, id);
        clubs_grid.setAdapter(adapter);
        ListViewUtil.setGridViewHeightBasedOnChildren(clubs_grid, 2);
    }


    private void add_data_to_people_list(int id) {
        String[] name;
        String[] designation;
        String[] mobileno;
        String[] emailid;

        //0 = cultural council
        //1 = science and technology council
        //2 = sports council
        if (id == 0) {
            name = new String[]{"Ms. Parishita Agrawal", "Mr. Yuvraj Chawla"};
            designation = new String[]{"General Secretary", "Associate General Secretary"};
            mobileno = new String[]{"7665961872", "9936622502"};
            emailid = new String[]{"gsec.cultural@lnmiit.ac.in", "21ucs239@lnmiit.ac.in"};
        } else if (id == 1) {
            name = new String[]{"Mr. Nanik Chaturvedi", "Ms. Aakanksha Singh"};
            designation = new String[]{"General Secretary", "Associate General Secretary"};
            mobileno = new String[]{"8209393282", "7738272986"};
            emailid = new String[]{"gsec.science@lnmiit.ac.in", "21ucc002@lnmiit.ac.in"};
        } else {
            name = new String[]{"Mr. Kaushal Rao", "Ms. Diya Shah"};
            designation = new String[]{"General Secretary", "Associate General Secretary"};
            mobileno = new String[]{"8740894226", "9168557097"};
            emailid = new String[]{"gsec.sports@lnmiit.ac.in", "21uec050@lnmiit.ac.in"};
        }

        people_info_adapter adapter = new people_info_adapter(inside_council_gymkhana.this, name, designation, mobileno, emailid);
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
        int[] mTileColor;
        int[] mImg;
        int[] mTextColor;
        int council_id;
        Context mContext;

        public card_adapter(Context context, String[] arTitle, int[] arColor, int[] arImg, int[] arTextColor, int id) {
            super(context, R.layout.img_text_card, R.id.imgcard_title, arTitle);
            mTitle = arTitle;
            mTileColor = arColor;
            mImg = arImg;
            mTextColor = arTextColor;
            council_id = id;
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
            vholder.card.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(mContext, mTileColor[position])));
            vholder.txtTitle.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(mContext, mTextColor[position])));
            vholder.logo_back_card.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(mContext, mTileColor[position])));

            vholder.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(inside_council_gymkhana.this, inside_club_fest_gymkhana.class);
                    intent.putExtra("club_img", mImg[position]);
                    ArrayList<String> list = new ArrayList<>();
                    String[] name, designation, mobileno, emailid;
                    String clubinfo = "";

                    if (council_id == 0) {
                        if (position == 0) {
                            //aaveg
                            clubinfo = "Nukkad Natak or Street theater is a form of theatrical performance in outdoor public spaces without a specific paying audience. It is one of the oldest forms of theater used to spread awareness on societal issues. Our club AAVEG - Nukkad Mandli brings you the real side of what nukkad natak exactly is; everything from loud monologues, moving slogans, powerful expressions and captivating music. It is a beautiful way of connecting with people and enlightening them about the issues that we are facing as a society. Our club has raised awareness on topics like body shaming, male/female sexual abuse, rights of LGBTQ community, menstruation, reservation and many more among common people. Over the years, our club has contributed to the society by performing at various locations like World Trade Park, Jaipur (WTP). We have also participated and even won in inter-college competitions of IIT Roorkee, Manipal University Jaipur and many more. Not just that, Aaveg is not only a club, it's a family! Hours and hours of relentless practice, tons of laughter, excitement and a little bit of nervousness have given us the bond that we will cherish for life.";
                            name = new String[]{"Chirag Jain", "Ayush Miglani", "Harish Venugopal", "Hitanshu Satpathy"};
                            designation = new String[]{"Coordinator", "Coordinator", "Coordinator", "Coordinator"};
                            mobileno = new String[]{"8279262220", "7838506711", "9811411795", "9938197742"};
                            emailid = new String[]{"22ucs055@lnmiit.ac.in", "22ucs044@lnmiit.ac.in", "22ucc039@lnmiit.ac.in", "22ucs237@lnmiit.ac.in"};

                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/AAVEG/aaveg_1.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/AAVEG/aaveg_2.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/AAVEG/aaveg_3.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/AAVEG/aaveg_4.JPG?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/AAVEG/aaveg_5.jpg?raw=true");

                            intent.putExtra("insta", ".");
                            intent.putExtra("gmail", "aaveg@lnmiit.ac.in");
                            intent.putExtra("youtube", ".");
                        } else if (position == 1) {
                            //media cell
                            clubinfo = "The Media Cell is the media body of LNMIIT who have their eyes and ears everywhere, looking to grasp the most important information; even from the most obscure events. Along with the singularly given responsibility of training anchors and hosts for all the events around the college, the Media Cell calls upon external guidance and internal sessions that train students in general communication and soft skills. Hosting a plethora of flagship events every year has become a part and parcel of the Media Cell. With storytellers, creators, artists, speakers, they are one of the most vibrant body on the campus with the ability to really do EVERYTHING.";
                            name = new String[]{"Abhinav Singh", "Suhani Gupta", "Abhey Raheja", "Krishna Rohira"};
                            designation = new String[]{"Coordinator", "Coordinator", "Coordinator", "Coordinator"};
                            mobileno = new String[]{"9643271207", "9636784450", "6280407479", "7727077033"};
                            emailid = new String[]{"22ucs004@lnmiit.ac.in", "22uec137@lnmiit.ac.in", "22ucs003@lnmiit.ac.in", "22ume018@lnmiit.ac.in"};

                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/MEDIA%20CELL/mediacell_1.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/MEDIA%20CELL/mediacell_2.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/MEDIA%20CELL/mediacell_3.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/MEDIA%20CELL/mediacell_4.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/MEDIA%20CELL/mediacell_5.jpg?raw=true");

                            intent.putExtra("insta", "https://www.instagram.com/mediacell_lnmiit/");
                            intent.putExtra("gmail", "mediacell@lnmiit.ac.in");
                            intent.putExtra("youtube", "https://www.youtube.com/@mediacell-lnmiit");
                        } else if (position == 2) {
                            //Rendition
                            clubinfo = "Rendition - The Theatre Society LNMIIT aims to promote drama education and provide various performances for students. The word ‘Rendition’ in itself emphasises “a performance or interpretation of something. This club has been designed for students fascinated with the aspects of theatre to enhance their interests and boost their skills in the field of acting, stage terminology, set building and costume design. Rendition has always endeavoured to put forth its maximum effort to continue its legacy and maintain its glory by striving on its principles of dedication, discipline and punctuality. This club provides a chance for students to strengthen their leadership skills and cooperation spirits since they need to work hand in hand to run the club, deal with the problems and design plenty of activities. This club always bolsters its members to amplify their self-confidence, poise and understanding of the nuance of emotions.";
                            name = new String[]{"Maitreyee Kulkarni", "Mohit Soni", "Sanyam Munot"};
                            designation = new String[]{"Coordinator", "Coordinator", "Coordinator"};
                            mobileno = new String[]{"9423810600", "9879798555", "8079030074"};
                            emailid = new String[]{"22ucc060@lnmiit.ac.in", "22ucs125@lnmiit.ac.in", "22ucs185@lnmiit.ac.in"};

                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/RENDITION/rendition_1.jpeg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/RENDITION/rendition_2.jpeg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/RENDITION/rendition_3.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/RENDITION/rendition_4.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/RENDITION/rendition_5.jpg?raw=true");

                            intent.putExtra("insta", "https://www.instagram.com/rendition_lnmiit/?img_index=1");
                            intent.putExtra("gmail", "rendition@lnmiit.ac.in");
                            intent.putExtra("youtube", "https://www.youtube.com/@Rendition.lnmiit");
                        } else if (position == 3) {
                            //Insignia
                            clubinfo = "INSIGNIA, was founded by our seniors of the Y11 batch to provide an opportunity to better the dancer in students through constant engagement and to encourage participation in dance events irrespective of the student's degree of talent. We hereby focus on building team coordination, discipline, and individual confidence to bring out the best in our members because winning is not important, shining is! The dance club is one of the most happening clubs of LNMIIT and it helps students stay fit, socialize and learn creative skills through dance. Time management, team management, and mind-body relationship are just to name a few. We adhere and persevere until we conquer! The students who have participated in other colleges have brought glory to our college in various performances, be it solo, group, duo, or dance battles and we continue to strive for more. Our motto? Practice like you never won and perform like you never lost.This is why everyone comprising our team wears an insignia of hard work, dedication, and pure love for dance!";
                            name = new String[]{"Palak Kabra", "Harsh Mange"};
                            designation = new String[]{"Coordinator", "Coordinator"};
                            mobileno = new String[]{"9468524500", "8799260747"};
                            emailid = new String[]{"22uec089@lnmiit.ac.in", "22ucs083@lnmiit.ac.in"};

                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/INSIGNIA/insignia_1.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/INSIGNIA/insignia_2.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/INSIGNIA/insignia_3.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/INSIGNIA/insignia_4.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/INSIGNIA/insignia_5.jpg?raw=true");

                            intent.putExtra("insta", "https://www.instagram.com/insignia_lnm?igsh=MXgweWkxdmx5OG9lbg==");
                            intent.putExtra("gmail", "insignia@lnmiit.ac.in");
                            intent.putExtra("youtube", "https://www.youtube.com/@insignia6397");
                        } else if (position == 4) {
                            //Capriccio
                            clubinfo = "Welcome to Capriccio, our small musical universe. Capriccio aims to take you on an emotional journey through beautiful melodies, harmonies, rhythms, and in short soulful pleasant music. Our club is made up of singers, instrumentalists, and producers who love music and have the potential to be great artists. It aims to provide you with comprehensive musical knowledge so that you can develop a deeper relationship with music. One thing is for sure, you will get to live the most memorable moments and will get to cherish the best memories of your college life. There are regular meetings among club members so that you can get to know each other and form bonds with others, interact with seniors, and learn about music because we believe Capriccio is a family, not a club.";
                            name = new String[]{"guneet garg", "chirag aggarwal", "rishabh rathi", "suyash mittal"};
                            designation = new String[]{"Coordinator", "Coordinator", "Coordinator", "Coordinator"};
                            mobileno = new String[]{"9773870874", "7990483678", "7300086947", "8287352648"};
                            emailid = new String[]{"22uec044@lnmiit.ac.in", "22ucs054@lnmiit.ac.in", "22ucs166@lnmiit.ac.in", "22ucs215@lnmiit.ac.in"};

                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/CAPRICCIO/capriccio_1.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/CAPRICCIO/capriccio_2.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/CAPRICCIO/capriccio_3.png?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/CAPRICCIO/capriccio_4.jpg?raw=true");

                            intent.putExtra("insta", "https://www.instagram.com/capriccio.lnmiit?igsh=eDB5NjkzZ3RwMjBn");
                            intent.putExtra("gmail", "capriccio@lnmiit.ac.in");
                            intent.putExtra("youtube", "https://www.youtube.com/@teamcapriccio/videos");
                        } else if (position == 5) {
                            //Imagination
                            clubinfo = "IMAGINATION is the photography and cinematography club of The LNM Institute of Information Technology,The club primarily covers any event by capturing them in photo and video formats. It consists of skillful and talented individuals who are extremely passionate in the domains of photography and cinematography. These members are selected after a thorough assessment of their skills. Imagination has four domains: Photography and Photo-editing, Cinematography and Video-editing, Graphics Designing, & Content Writing. The club conducts various events and competitions such as Through the lens, Click Start, Photowalk, workshops, Kalakriti, FMC, etc to upskill its members and also other students can exercise their creativity through these.The club also conducts various workshops like photo editing, video editing, and graphic designing. Anyone who wishes to showcase their talents can participate in the events and workshops.";
                            name = new String[]{"Krishna Manchanda", "Aman Aggarwal", "Saurav Choudhary ", "Harsh Jindal"};
                            designation = new String[]{"Coordinator", "Coordinator", "Coordinator", "Coordinator"};
                            mobileno = new String[]{"7455016831", "9811361863", "6205681502", "8318111765"};
                            emailid = new String[]{"22ucs111@lnmiit.ac.in", "22uec012@lnmiit.ac.in", "22ucs190@lnmiit.ac.in", "22ucs084@lnmiit.ac.in"};

                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/IMAGI/imag_1.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/IMAGI/imag_2.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/IMAGI/imag_3.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/IMAGI/imag_4.jpg?raw=true");

                            intent.putExtra("insta", "https://www.instagram.com/imagination.lnmiit?igsh=eWcwMW14a3Y1ejhq");
                            intent.putExtra("gmail", "imagination@lnmiit.ac.in");
                            intent.putExtra("youtube", "https://youtube.com/@imagination_lnmiit");
                        } else if (position == 6) {
                            //Sankalp
                            clubinfo = "Sankalp, The Social club of LNMIIT Jaipur, laid its foundation on the stiff rocks of helping and giving our valuables and necessities despite being a person who expects to get something in return. Here we work on social causes associated with the college mess workers, problems faced by people in the village near campus, and organizing self-growth and learning sessions for club dignitaries. Events such as 'Sahyog' , 'Make A Meal' and 'Janmashtami Celebration' are some campus events celebrated and organized with full enthusiasm and excitement. At last, be a person with a strong will for contribution.";
                            name = new String[]{"Harsh Tailor", "Adarsh Mishra", "Harsh Agrawal", "Pankaj Kabra", "Parth Bansal"};
                            designation = new String[]{"Coordinator", "Coordinator", "Coordinator", "Coordinator", "Coordinator"};
                            mobileno = new String[]{"6367325245", "7426046332", "9305351993", "7976107688", "7496836515"};
                            emailid = new String[]{"22uec051@lnmiit.ac.in", "22ucs005@lnmiit.ac.in", "22uec046@lnmiit.ac", "22uec090@lnmiit.ac", "22ucs146@lnmiit.ac.in"};

                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/SANKALP/sankalp_1.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/SANKALP/sankalp_2.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/SANKALP/sankalp_3.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/SANKALP/sankalp_4.jpg?raw=true");

                            intent.putExtra("insta", "https://www.instagram.com/sankalp.lnmiit/");
                            intent.putExtra("gmail", "sankalp@lnmiit.ac.in");
                            intent.putExtra("youtube", ".");
                        } else if (position == 7) {
                            //Vignette
                            clubinfo = "Vignette - The LNMIIT Art & Craft Club is responsible for creating an extravagant environment. Creativity is what the Art Club nurtures. It intensifies the beauty of normality into something appreciable. One of the most active clubs of the Cultural Council, Art Club organizes art events throughout the session to bring out the talent in every possible way. From displaying artistic talent to decorating the college for the fests and events to bring the set aura, there isn't a moment when the art club fails to showcase its talent. The club also organizes intra-college events like Art Attack, T-shirt Painting, Face Painting, and more. These events are in the form of competitions where you can showcase your talent and artistic skills on paper, canvas, t-shirt, or even on your face. There are no limitations while being creative; the club flaunts its artwork in various fields like 3-D art, Sketching, Painting, and many more. The club welcomes everyone who aspires to be an artist, where your creative mind can put ideas into reality.";
                            name = new String[]{"Aryan gupta", "Nukul Sharma", "Arsh Gupta", "Naman Soni", "Somya Kedia"};
                            designation = new String[]{"Coordinator", "Coordinator", "Coordinator", "Coordinator", "Coordinator"};
                            mobileno = new String[]{"9064280911", "8440963363", "8769198695", "7597562205", "9413554064"};
                            emailid = new String[]{"21ucs036@lnmiit.ac.in", "21ucs253@lnmiit.ac.in", "21ucs032@lnmiit.ac.in", "22ume023@lnmiit.ac.in", "22ucc126@lnmiit.ac.in"};

                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/VIGNETTE/vignette_1.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/VIGNETTE/vignette_2.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/VIGNETTE/vignette_3.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/VIGNETTE/vignette_4.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/VIGNETTE/vignette_5.jpg?raw=true");

                            intent.putExtra("insta", "https://www.instagram.com/vignette_lnmiit?utm_source=ig_web_button_share_sheet&igsh=ZDNlZDc0MzIxNw==");
                            intent.putExtra("gmail", "vignette@lnmiit.ac.in");
                            intent.putExtra("youtube", ".");
                        } else if (position == 8) {
                            //Eminence
                            clubinfo = "Fashion is about dressing according to what’s fashionable. Style is more about being yourself.’ —Oscar de la RentaEminence. Fashion club of The LNMIIT believes in this excerpt from a saying by the legendary Oscar de la Renta and although being a fashion club, style, personality, liveliness and creativity are the club’s four central pillars.You can opt your heart’s desire from ramp walking, make-up, fashion designing and demonstrate your outstanding abilities through talent and self-confidence amalgamation. The vibrant Vogue Fashion Week in Vivacity, and events like gusto pivot more around your confidence and attitude, than what you wear. Organising Rubaroo, the fresher's night, gives you power to avail your aesthetic minds and compose one of your most memorable of days. The club rejoices in portraying vehemence for showing off your best while giving credence to the flaws which never lets its fire and fierceness to cease.";
                            name = new String[]{"Prachi Goyal", "Riya Bora", "Shubh Jaiswal"};
                            designation = new String[]{"Coordinator", "Coordinator", "Coordinator"};
                            mobileno = new String[]{"6376974183", "9548392263", "9517555612"};
                            emailid = new String[]{"22ucc075@lnmiit.ac.in", "22ucc087@lnmiit.ac.in", "22uec131@lnmiit.ac.in"};

                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/EMINENCE/eminence_1.jpeg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/EMINENCE/eminence_2.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/EMINENCE/eminence_3.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/EMINENCE/eminence_4.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/EMINENCE/eminence_5.JPG?raw=true");

                            intent.putExtra("insta", "https://www.instagram.com/eminence.lnmiit?igsh=NXI0bzBscTIxbzZn");
                            intent.putExtra("gmail", "Eminence@lnmiit.ac.in");
                            intent.putExtra("youtube", "https://www.youtube.com/@FashionClubLNMIIT");
                        } else if (position == 9) {
                            //Fundoo
                            clubinfo = "After coming to college, students miss their family most at the time of the festival. So we Fundoo Club tries to celebrate festivals in such a way that students get interested in festivals even in college. We celebrate every festival here as an LNMIIT family.";
                            name = new String[]{"Divyansh Arora", "Siddharth Choudhary", "Yuvika Gupta", "Yashi Srivastava"};
                            designation = new String[]{"Coordinator", "Coordinator", "Coordinator", "Coordinator"};
                            mobileno = new String[]{"7877374303", "6351620664", "9216746454", "8840657829"};
                            emailid = new String[]{"22ucc037@lnmiit.ac.in", "22ucs210@lnmiit.ac.in", "23ume560@lnmiit.ac.in", "23ucc620@lnmiit.ac.in"};

                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/Fundoo/fundoo_1.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/Fundoo/fundoo_2.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/Fundoo/fundoo_3.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/Fundoo/fundoo_4.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/Fundoo/fundoo_5.jpeg?raw=true");

                            intent.putExtra("insta", "https://www.instagram.com/fundoo.lnmiit?igsh=MTljMnNxYjY4YW1kMQ==");
                            intent.putExtra("gmail", "fundoo@lnmiit.ac.in");
                            intent.putExtra("youtube", ".");
                        } else {
                            //LC
                            clubinfo = "A club that provides literary enthusiasts with a platform to explore, expand, and exhilarate their psyches with literature and thoughts from the old worlds to the new. A club that draws out the orator, writer, and philosopher in you. A club that brings out the various sides and looks of a writer listener or a person who is sound in terms of knowledge acquainted with literature. Through our various activities and events, we tend to make a creative person a more creative and ingenious one, thus enhancing the on-stage prowess of the person. A club that offers opportunities to appreciate different types of literature and increase their own literary skills. This Literary Club aims at not only refining the literary skills of the students but also developing their logic and curiosity to know more and instil in them the confidence to speak well.";
                            name = new String[]{"Sahil Gaur", "Abir Samanta"};
                            designation = new String[]{"Coordinator", "Coordinator"};
                            mobileno = new String[]{"8528391394", "9664316180"};
                            emailid = new String[]{"22ucs172@lnmiit.ac.in", "22uec003@lnmiit.ac.in"};

                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/LC/lc_1.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/LC/lc_2.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/LC/lc_3.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/LC/lc_4.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/cultural_clubs/LC/lc_5.jpg?raw=true");

                            intent.putExtra("insta", "https://www.instagram.com/literary_lnmiit?igsh=MWJqbWI0bXM2Z3E5aQ==");
                            intent.putExtra("gmail", "literary@lnmiit.ac.in");
                            intent.putExtra("youtube", "https://youtube.com/@literarycommitteelnmiit?si=CwndFbELqE5FLv-H");
                        }
                    } else if(council_id == 1){
                        if (position == 0) {
                            //astro
                            clubinfo = "The Astronomy Club promotes the interest of students towards the awe-inspiring field of Astronomy and space exploration while striving to increase the craze about the various fields enclosed within. It is one of the most active clubs in LNMIIT. With creative and enthusiastic minds in the club, we try to come up with highly entertaining events for everyone, time to time. With our wide-ranging events throughout the year, we try to keep folks entertained. Afterall that's what college life is, a bit of entertainment, going in hand with academics.";
                            name = new String[]{"Ishaan Sharma", "Hiya Jain", "Palakurthy Guneeth", "Ansh Chawla"};
                            designation = new String[]{"Coordinator", "Coordinator", "Coordinator", "Coordinator"};
                            mobileno = new String[]{"9508146626", "9701234550", "7993391140", "9910713737"};
                            emailid = new String[]{"22uec056@lnmiit.ac.in", "22uec054@lnmiit.ac.in", "22ucs144@lnmiit.ac.in", "22ucs020@lnmiit.ac.in"};

                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/ASTRONOMY/astro_1.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/ASTRONOMY/astro_2.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/ASTRONOMY/astro_3.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/ASTRONOMY/astro_4.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/ASTRONOMY/astro_5.jpg?raw=true");

                            intent.putExtra("insta", "https://www.instagram.com/astronomylnmiit/");
                            intent.putExtra("gmail", "astronomyclub@lnmiit.ac.in");
                            intent.putExtra("youtube", ".");
                        } else if (position == 1) {
                            //cipher
                            clubinfo = "With the aim of the betterment of the college community, the motive of this club is to bring awareness about the ongoing threats in the Cyber Security world and prevention methods against adversaries and how Blockchain Technology can be used for securing it to the next level. The club’s motive is to create a healthy and knowledgeable environment and achieve various goals listed below that would enhance your performance: To cultivate CyberSecurity and Blockchain culture amongst the students, Introducing the concepts of Smart contracts, Blockchain Technology & Web3, Introducing students to Ethical and Competitive Hacking. CYBER SECURITY AND BLOCKCHAIN are upcoming fields with varied and exciting opportunities. CIPHER will help you dive in and grab the opportunities. It will also create a platform where you can solve problems and have discussions about the same.";
                            name = new String[]{"Bal Narayan Singh", "Suryansh Chauhan", "Devarsh Parmar", "Parth Garg"};
                            designation = new String[]{"Coordinator", "Coordinator", "Coordinator", "Coordinator"};
                            mobileno = new String[]{"8789925219", "7678161297", "9998864848", "8930033025"};
                            emailid = new String[]{"22uec030@lnmiit.ac.in", "22ucs214@lnmiit.ac.in", "22ucs063@lnmiit.ac.in", "22ucs147@lnmiit.ac.in"};

                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/CIPHER/cipher_1.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/CIPHER/cipher_2.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/CIPHER/cipher_3.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/CIPHER/cipher_4.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/CIPHER/cipher_5.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/CIPHER/cipher_6.jpg?raw=true");

                            intent.putExtra("insta", "https://www.instagram.com/cipher.lnmiit/");
                            intent.putExtra("gmail", "cipher2023@lnmiit.ac.in");
                            intent.putExtra("youtube", ".");
                        } else if (position == 2) {
                            //Debsoc
                            clubinfo = "Lord Byron once said, 'Those who will not reason are bigots, those who cannot are fools, and those who dare not, are slaves.' We believe you come as a learner to the world and live as a person in society. The person in you should be robust to reason and realize the arguments.To inculcate reasoning and unleash the master within, The LNMIIT has a sigma debating club, The Debate Society. DebSoc has always been the charm for debaters with the best in professional suites and orators. The society strives to develop a rational personality among the students by harmoniously promoting debates and discussions in the form of MUNs, Group Discussions, Parliamentary Debates, and Extempores. Acknowledging the value of exposure and dialogue, the DebSoc is one of its kind to mold you as a conclusive lawyer of words.";
                            name = new String[]{"Devansh Rawal", "Vaibhav Aggarwal", "Chirag Mehta"};
                            designation = new String[]{"Coordinator", "Coordinator", "Coordinator"};
                            mobileno = new String[]{"9928565121", "6376897192", "9810133673"};
                            emailid = new String[]{"22ucc034@lnmiit.ac.in", "22ucc112@lnmiit.ac.in", "22ucc030@lnmiit.ac.in"};

                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/DEBSOC/debsoc_1.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/DEBSOC/debsoc_2.JPG?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/DEBSOC/debsoc_3.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/DEBSOC/debsoc_4.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/DEBSOC/debsoc_5.JPG?raw=true");

                            intent.putExtra("insta", "https://www.instagram.com/thedebatesocietylnmiit/");
                            intent.putExtra("gmail", "debsoc@lnmiit.ac.in");
                            intent.putExtra("youtube", ".");
                        } else if (position == 3) {
                            //Phoenix
                            clubinfo = "Phoenix is the club where practicality comes most into reality. Manifesting 2-D designs into 3-D working machinery of various types. The collective knowledge of the latest technology is vast, with in-depth information about various aspects. The Hardware division conducts spectacular events like RC planes, Drone Building, Torque, LFR, and ROBOWAR. It gives you a chance to play with circuits and motors with a child's curiosity. The Software division ventures into domains like AI, ML, Web, Android Development, and more. One should never miss the workshops and events conducted by this division. The Quarks division is the most diverse and inclusive having Content Writing, Graphic Designing, Video Editing and management under its name. Get ready to manage colossal events and make visually depicting posters and videos. Above all, Phoenix plays a significant role in organizing the events in Plinth.";
                            name = new String[]{"Hardik Agrawal", "Anmol Jain", "Arunil Jain"};
                            designation = new String[]{"Coordinator", "Coordinator", "Coordinator"};
                            mobileno = new String[]{"9511544462", "7017283915", "9755345705"};
                            emailid = new String[]{"22uec045@lnmiit.ac.in", "22uec017@lnmiit.ac.in", "22ume005@lnmiit.ac.in"};

                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/PHOENIX/phoenix_1.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/PHOENIX/phoenix_2.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/PHOENIX/phoenix_3.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/PHOENIX/phoenix_4.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/PHOENIX/phoenix_5.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/PHOENIX/phoenix_6.jpg?raw=true");

                            intent.putExtra("insta", "https://www.instagram.com/phoenix.lnmiit/");
                            intent.putExtra("gmail", "phoenixclub@lnmiit.ac.in");
                            intent.putExtra("youtube", "http://www.youtube.com/@PhoenixClubLNMIIT");
                        } else if (position == 4) {
                            //cybros
                            clubinfo = "Cybros is a core hub for programmers aiming to keep the booming “coding culture” of LNMIIT reigning. The official coding club, Cybros is composed of top prolific coders whose binding power has rendered many unfathomable achievements. Cybros nurtures and guides fresher batches by forming a spirit of Competitive Programming from the first semester itself. Furthermore, it organises CyTalks which behaves as a multifaceted offline event posing as a resource-packed programming workshop, a motivational chat, or a mentoring session.It is also notorious for holding many contests like CodeLNM: an intra-college contest enjoying mighty participation, and weekly contest series like Placement Series and Beginners Series aimed at senior batches and beginners respectively. In Addition, CyHub — Cybros’ Codeforces group is a one-stop destination for topic-specific resources and archives of the previous contests held. In a nutshell, Cybros acts like a web interlinking enthusiastic learners at LNMIIT and scooping them into the realm of programming.";
                            name = new String[]{"Vaibhav Rai", "Om Gupta"};
                            designation = new String[]{"Coordinator", "Coordinator"};
                            mobileno = new String[]{"8171633565", "8278682310"};
                            emailid = new String[]{"21ucs225@lnmiit.ac.in", "21ucs140@lnmiit.ac.in"};

                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/CYBROS/cybros_1.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/CYBROS/cybros_2.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/CYBROS/cybros_3.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/CYBROS/cybros_4.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/CYBROS/cybros_5.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/CYBROS/cybros_6.jpeg?raw=true");

                            intent.putExtra("insta", "https://www.instagram.com/cybros_lnmiit?igsh=MTY4c2k3eTZvYzZraw==");
                            intent.putExtra("gmail", "cybrosclub@lnmiit.ac.in");
                            intent.putExtra("youtube", ".");
                        } else if (position == 5) {
                            //quizinga
                            clubinfo = "Quizzinga is a sheltering tree for individuals harbouring weird facts or having a knack of a specific topic. It is the holy shrine for enthusiasts of anime, sports, biz, cinema, history etc. and serves as a commonplace for geeks to share their interests through quizzing. Being the official quizzing body of LNMIIT, Quizzinga is inculcated with the responsibility of riveting students’ interest in quizzing. It organises events such as First Blood: The Freshers’ Quiz, Mega Quiz, Topic Specific Insta Quizzes and club quizzes for its members. Furthermore, Quizzinga takes the responsibility of holding IPL and Football Auction: adrenaline packed events for strategists to build their own cricket/football team. Dubbed as the club of “national calibre”, Quizzinga has amassed a massive reach by being National Champions in 2019 and National Runner-Ups in 2022 at Tata Crucibles: The Campus Business Quiz. It has also been the winner of inter-college quiz events of MNIT, DAIICT, SRCC, IITD and finished FIRST in SNU InQube 2021.";
                            name = new String[]{"Anwita Sarangi ", "Asher Ejaz", "Shourya Kumar Singh"};
                            designation = new String[]{"Coordinator", "Coordinator", "Coordinator"};
                            mobileno = new String[]{"7506866376", "8210522974", "8765848035"};
                            emailid = new String[]{"22ucs030@lnmiit.ac.in", "22ucs234@lnmiit.ac.in", "22ume036@lnmiit.ac.in"};

                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/QUIZZINGA/quizzinga_1.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/QUIZZINGA/quizzinga_2.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/QUIZZINGA/quizzinga_3.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/QUIZZINGA/quizzinga_4.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/QUIZZINGA/quizzinga_5.jpg?raw=true");

                            intent.putExtra("insta", "https://www.instagram.com/quizzingalnm/?hl=en");
                            intent.putExtra("gmail", "quizzinga@lnmiit.ac.in");
                            intent.putExtra("youtube", ".");
                        } else {
                            //ECell
                            clubinfo = "Future builders that are interested in learning about entrepreneurship, cryptocurrency, the stock market, web3, and several other fields come to this location for all of their learnings. They seek guidance in 5 major domains being event planning, marketing, management, sponsorship, content creation and designing which add up to create a well verse soft skill development and a variety of other subjects, all of which contribute to a child's holistic development and help him grow into a multi-talented adult.The exclusive club at our campus that collaborates with several Tech colleges across India is E-Cell, with its collaboration with Entrepreneurship Development Cell, IIT Roorkee, serving as a prominent example. We organize and participate in various funding events and interact closely with startup founders and make our members understand the crucial stages of start-up ecosystem.";
                            name = new String[]{"Varun Ashok", "Yash Gautam"};
                            designation = new String[]{"Coordinator", "Coordinator"};
                            mobileno = new String[]{"7678445442", "9971776764"};
                            emailid = new String[]{"21uec153@lnmiit.ac.in", "21ucs235@lnmiit.ac.in"};

                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/E-CELL/ecell_1.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/E-CELL/ecell_2.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/E-CELL/ecell_3.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/E-CELL/ecell_4.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/tech_clubs/E-CELL/ecell_5.jpg?raw=true");

                            intent.putExtra("insta", ".");
                            intent.putExtra("gmail", ".");
                            intent.putExtra("youtube", ".");
                        }
                    } else {
                        if (position == 0) {
                            //badminton
                            clubinfo = "";
                            name = new String[]{"Ankur Arora", "Rishabh Jain", "Tanvi Bansal"};
                            designation = new String[]{"Coordinator", "Coordinator", "Coordinator"};
                            mobileno = new String[]{"9024798061", "9462928306", "8955721475"};
                            emailid = new String[]{"22ucs018@lnmiit.ac.in", "22ucs165@lnmiit.ac.in", "22ucs217@lnmiit.ac.in"};

                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Badminton/badminton_1.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Badminton/badminton_2.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Badminton/badminton_3.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Badminton/badminton_4.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Badminton/badminton_5.jpg?raw=true");

                            intent.putExtra("insta", ".");
                            intent.putExtra("gmail", ".");
                            intent.putExtra("youtube", ".");
                        } else if (position == 1) {
                            //chess
                            clubinfo = "";
                            name = new String[]{"Prabhjot Singh", "Anukul Jain", "Divyank Sharma", "Yathartha Malpani"};
                            designation = new String[]{"Coordinator", "Coordinator", "Coordinator", "Coordinator"};
                            mobileno = new String[]{"9454747541", "7060567930", "8824485480", "7489727242"};
                            emailid = new String[]{"22ucc074@lnmiit.ac.in", "22ucs026@lnmiit.ac.in", "22ucs072@lnmiit.ac.in", "22ume040@lnmiit.ac.in"};

                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Chess/chess_1.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Chess/chess_2.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Chess/chess_3.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Chess/chess_4.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Chess/chess_5.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Chess/chess_6.jpg?raw=true");

                            intent.putExtra("insta", ".");
                            intent.putExtra("gmail", ".");
                            intent.putExtra("youtube", ".");
                        } else if (position == 2) {
                            //Volleyball
                            clubinfo = "";
                            name = new String[]{"Hemendra Yaduvanshi", "Prabhat singh", "Sanidhaya Mundra"};
                            designation = new String[]{"Coordinator", "Coordinator", "Coordinator", "Coordinator"};
                            mobileno = new String[]{"8890605538", "8003021328", "9119337606"};
                            emailid = new String[]{"22ume014@lnmiit.ac.in", "22uec096@lnmiit.ac.in", "22uec116@lnmiit.ac.in"};

                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Volley%20Ball/vollyball_1.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Volley%20Ball/vollyball_2.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Volley%20Ball/vollyball_3.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Volley%20Ball/vollyball_4.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Volley%20Ball/vollyball_5.jpg?raw=true");

                            intent.putExtra("insta", "https://www.instagram.com/lnmiit.volleyball?igsh=MWNibzBpbW1qc3NmMQ==");
                            intent.putExtra("gmail", ".");
                            intent.putExtra("youtube", ".");
                        } else if (position == 3) {
                            //Cricket
                            clubinfo = "";
                            name = new String[]{"Hardik Makkar", "Navam Garg", "Kavya Khurana", "Krish Rajgarhia "};
                            designation = new String[]{"Coordinator", "Coordinator", "Coordinator", "Coordinator"};
                            mobileno = new String[]{"9990660200", "9896302234", "7888560226", "9241998064"};
                            emailid = new String[]{"22ucs080@lnmiit.ac.in", "22ucs136@lnmiit.ac.in", "22ucs105@lnmiit.ac.ib", "22ucs109@lnmiit.ac.in"};

                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Cricket/circket_1.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Cricket/circket_2.jpg?raw=true");

                            intent.putExtra("insta", "https://www.instagram.com/_cricket_lnmiit");
                            intent.putExtra("gmail", ".");
                            intent.putExtra("youtube", ".");
                        } else if (position == 4) {
                            //basketball
                            clubinfo = "";
                            name = new String[]{"Nishit Jain", "Akshat Sudhanshu", "Arindam Chaudhary"};
                            designation = new String[]{"Coordinator", "Coordinator", "Coordinator"};
                            mobileno = new String[]{"7014286540", "9950307260", "9811726961"};
                            emailid = new String[]{"22ucc068@lnmiit.ac.in", "22uec010@lnmiit.ac.in", "22dec2003@lnmiit.ac.in"};

                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Basket%20Ball/basketball_1.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Basket%20Ball/basketball_2.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Basket%20Ball/basketball_3.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Basket%20Ball/basketball_4.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Basket%20Ball/basketball_5.jpg?raw=true");

                            intent.putExtra("insta", "https://www.instagram.com/lnmiit_basketball/");
                            intent.putExtra("gmail", ".");
                            intent.putExtra("youtube", ".");
                        } else if (position == 5) {
                            //football
                            clubinfo = "";
                            name = new String[]{"Shreyansh Badoni", "Moosa Hasan", "Shreyas Shrivastava"};
                            designation = new String[]{"Coordinator", "Coordinator", "Coordinator"};
                            mobileno = new String[]{"9119702092", "8800521087", "7738992048"};
                            emailid = new String[]{"22ucs204@lnmiit.ac.in", "22ume022@lnmiit.ac.in", "22ucs205@lnmiit.ac.in"};

                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/FootBall/football_1.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/FootBall/football_2.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/FootBall/football_3.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/FootBall/football_4.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/FootBall/football_5.jpg?raw=true");

                            intent.putExtra("insta", ".");
                            intent.putExtra("gmail", ".");
                            intent.putExtra("youtube", ".");
                        } else if (position == 6) {
                            //kabaddi
                            clubinfo = "";
                            name = new String[]{"Anish Manoj Pande", "Ayush Agrawal", "Prem Choudhary"};
                            designation = new String[]{"Coordinator", "Coordinator", "Coordinator"};
                            mobileno = new String[]{"7822027790", "8559853384", "7728834428"};
                            emailid = new String[]{"22uec016@lnmiit.ac.in", "22uec029@lnmiit.ac.in", "22ume027@lnmiit.ac.in"};

                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Kabaddi/kabaddi_1.JPG?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Kabaddi/kabaddi_2.JPG?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Kabaddi/kabaddi_3.JPG?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Kabaddi/kabaddi_4.JPG?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Kabaddi/kabaddi_5.jpg?raw=true");

                            intent.putExtra("insta", "https://www.instagram.com/lnmiit_kabaddi/");
                            intent.putExtra("gmail", ".");
                            intent.putExtra("youtube", ".");
                        } else if (position == 7) {
                            //Lawn Tennis
                            clubinfo = "";
                            name = new String[]{"Ansh Chawla", "Devansh Mehra"};
                            designation = new String[]{"Coordinator", "Coordinator"};
                            mobileno = new String[]{"9910713737", "9358894590"};
                            emailid = new String[]{"22ucs020@lnmiit.ac.in", "22uec040@lnmiit.ac.in"};

                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Lawn%20Tennis/lawntennis_1.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Lawn%20Tennis/lawntennis_2.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Lawn%20Tennis/lawntennis_3.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Lawn%20Tennis/lawntennis_4.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Lawn%20Tennis/lawntennis_5.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Lawn%20Tennis/lawntennis_6.jpg?raw=true");

                            intent.putExtra("insta", ".");
                            intent.putExtra("gmail", ".");
                            intent.putExtra("youtube", ".");
                        } else if (position == 8) {
                            //Table Tennis
                            clubinfo = "";
                            name = new String[]{"Ayush Jain", "Naitik Jasani", "Harsh Chandgotia ", "Mitali Manya"};
                            designation = new String[]{"Coordinator", "Coordinator", "Coordinator", "Coordinator"};
                            mobileno = new String[]{"7339866228", "8852002717", "6290629698", "7023761771"};
                            emailid = new String[]{"22ucs043@lnmiit.ac.in", "22ucs131@lnmiit.ac.in", "22uec047@lnmiit.ac.in", "22uec081@lnmiit.ac.in"};

                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Table%20Tennis/tabetenis_1.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Table%20Tennis/tabetenis_2.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Table%20Tennis/tabetenis_3.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Table%20Tennis/tabetenis_4.jpg?raw=true");
                            list.add("https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/ClubImages/sports_club/Table%20Tennis/tabetenis_5.jpg?raw=true");

                            intent.putExtra("insta", ".");
                            intent.putExtra("gmail", ".");
                            intent.putExtra("youtube", ".");
                        } else {
                            //Squash
                            clubinfo = "";
                            name = new String[]{};
                            designation = new String[]{};
                            mobileno = new String[]{};
                            emailid = new String[]{};

                            list.add("");

                            intent.putExtra("insta", "");
                            intent.putExtra("gmail", "");
                            intent.putExtra("youtube", "");
                        }
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
        CardView card, logo_back_card;
        ImageView logo;

        public VHolder_card(View r) {
            txtTitle = r.findViewById(R.id.imgcard_title);
            card = r.findViewById(R.id.imgcard_card);
            logo = r.findViewById(R.id.imgcard_image);
            logo_back_card = r.findViewById(R.id.img_card_card_imageback);
        }

    }
}