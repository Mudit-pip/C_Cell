package com.lnmiit.c_cell.College_tab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.lnmiit.c_cell.PDF_display;
import com.lnmiit.c_cell.R;

public class Curriculum_subjects extends AppCompatActivity {

    CardView cs, cce, ece, me, cs_int, ece_int;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_curriculum_subjects);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cs = findViewById(R.id.college_curriculam_cs);
        cce = findViewById(R.id.college_curriculam_cce);
        ece = findViewById(R.id.college_curriculam_ece);
        me = findViewById(R.id.college_curriculam_me);
        cs_int = findViewById(R.id.college_curriculam_cs_int);
        ece_int = findViewById(R.id.college_curriculam_ece_int);

        cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Curriculum_subjects.this, PDF_display.class);
                intent.putExtra("pdfUrl", "https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/pdf/CSE.pdf?raw=true");
                intent.putExtra("operation", 1);
                startActivity(intent);
            }
        });

        cce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Curriculum_subjects.this, PDF_display.class);
                intent.putExtra("pdfUrl", "https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/pdf/CCE.pdf?raw=true");
                intent.putExtra("operation", 1);
                startActivity(intent);
            }
        });

        ece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Curriculum_subjects.this, PDF_display.class);
                intent.putExtra("pdfUrl", "https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/pdf/ECE.pdf?raw=true");
                intent.putExtra("operation", 1);
                startActivity(intent);
            }
        });

        me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Curriculum_subjects.this, PDF_display.class);
                intent.putExtra("pdfUrl", "https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/pdf/ME.pdf?raw=true");
                intent.putExtra("operation", 1);
                startActivity(intent);
            }
        });

        cs_int.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Curriculum_subjects.this, PDF_display.class);
                intent.putExtra("pdfUrl", "https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/pdf/CSE_Integrated.pdf?raw=true");
                intent.putExtra("operation", 1);
                startActivity(intent);
            }
        });

        ece_int.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Curriculum_subjects.this, PDF_display.class);
                intent.putExtra("pdfUrl", "https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/pdf/ECE_Integrated.pdf?raw=true");
                intent.putExtra("operation", 1);
                startActivity(intent);
            }
        });
    }
}