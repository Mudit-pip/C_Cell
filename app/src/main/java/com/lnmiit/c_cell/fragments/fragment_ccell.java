package com.lnmiit.c_cell.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.lnmiit.c_cell.INLOG1_homescreen;
import com.lnmiit.c_cell.ListViewUtil;
import com.lnmiit.c_cell.R;
import com.lnmiit.c_cell.gymkhana.fragment_gymkhana;
import com.lnmiit.c_cell.onboarding_screen;

public class fragment_ccell extends Fragment {


    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;
    TextView ccell_info_lbl;
    Button signout_btn;
    TextView convmsg_1_lbl, convmsg_2_lbl;
    ImageView mail1, mail2, mail3, call1, call2, call3;

    String conv_msg_para1 = "Welcome to a meaningful and rewarding experience at the LNM Institute of Information Technology, Jaipur. As you embark on your journey as an LNMIITian, you and your family are full of excitement and hope, as well as a range of queries and concerns in your mind.";
    String conv_msg_para2 = "The C-Cell application has been designed by the LNMIIT Counselling and Guidance Cell to help you navigate your college campus and uncover the answers to possibly all the questions you might have regarding your day-to-day life on campus. The app provides a complete set of information about Institute resources, academic programs, campus life, rules of behavior and the plethora of co-curricular activities that are an integral part of your identity as an LNMIIT student.\n" +
            "\n" +
            "I hope this user-friendly app proves to be a one-stop solution for your information needs.\n" +
            "\n" +
            "Best wishes!";
    String[] assocordi = {"Abhinav Singh", "Guneet Garg", "Nemil Kamdar", "Sanidhya Baldwa", "Tanvi Bansal", "Yash Sharma"};
    String ccellinfo = "LNMIIT Counselling & Guidance Cell (C-Cell) is a body that functions with the objective of facilitating the fresh batch make a smooth and healthy transition from 'new students' to LNMIITians, sensitize them with the LNMIIT ethos, help provide answers to their queries ranging from academic to personal and social ones. It works towards helping them adjust to the new campus as a home away from home. It undertakes a variety of roles and responsibilities ranging from organizing the Orientation Programme for the new batch, providing support in the admission process, document verification & reporting, conducting the Student-Faculty Mentorship Programme and related activities during the academic year.";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ccell, container, false);
        ccell_info_lbl = v.findViewById(R.id.frag_ccell_info);
        convmsg_1_lbl = v.findViewById(R.id.frag_ccell_message_para1);
        convmsg_2_lbl = v.findViewById(R.id.frag_ccell_message_para2);
        signout_btn = v.findViewById(R.id.ccell_signoutbtn);
        mail1 = v.findViewById(R.id.mail1);
        mail2 = v.findViewById(R.id.mail2);
        mail3 = v.findViewById(R.id.mail3);
        call1 = v.findViewById(R.id.call1);
        call2 = v.findViewById(R.id.call2);
        call3 = v.findViewById(R.id.call3);

        convmsg_1_lbl.setText(conv_msg_para1);
        convmsg_2_lbl.setText(conv_msg_para2);

        ccell_info_lbl.setText(ccellinfo);

        mAuth = FirebaseAuth.getInstance();

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(getContext(), gso);
        FirebaseUser currentUser = mAuth.getCurrentUser();
        signout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });


        mail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + "22ucc065@lnmiit.ac.in"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "");
                intent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(intent);
            }
        });

        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + "9413923341"));
                startActivity(intent);
            }
        });


        mail2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + "22uec053@lnmiit.ac.in"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "");
                intent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(intent);
            }
        });

        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + "9329776989"));
                startActivity(intent);
            }
        });


        mail3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + "22ucc023@lnmiit.ac.in"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "");
                intent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(intent);
            }
        });

        call3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + "6375591132"));
                startActivity(intent);
            }
        });

        return v;
    }

    private void signOut() {
        // Firebase sign out
        mAuth.signOut();

        // Google sign out
        mGoogleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                updateUI(null);
            }
        });
    }

    private void updateUI(FirebaseUser user) {
        if (user == null) {
            // User is signed out, redirect to login activity
            Intent intent = new Intent(getContext(), onboarding_screen.class);
            startActivity(intent);
            getActivity().finish();
        }
    }

}