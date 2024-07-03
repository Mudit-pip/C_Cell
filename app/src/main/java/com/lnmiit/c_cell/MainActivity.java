package com.lnmiit.c_cell;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] details = {"Report at your respective hostels.",
            "Please move to the LT-9 or 10 and wait for your token to be called.",
            "Once your token is called, please report at any of the desks present in front of LT -1 or  LT -2.",
            "After getting your documents verified and stamped, move to LT-3 for collecting your college credentials.",
            "After receiving your credentials, move to LT-4, to get your biometric data recorded.",
    "After being done with ___, move to CP Lab 1 for filling out the anti ragging affidavit. Make sure you collect your ID card before you leave."};
    String[] location = {"Boys: BH-1 \uD83D\uDCCD\nGirls: GH \uD83D\uDCCD\n",
            "LT 9 and 10",
            "LT 1 and LT2",
            "LT3",
            "LT4",
    "CP Lab - 1\nCP Lab - 2: On the first floor"};
    public double boyshostel_latitude = 26.93407280436765;
    public double boyshostel_longitude = 75.92304367055213;
    public double girlshostel_latitude = 26.935126004378677;
    public double girlshostel_longitude = 75.92261512944617;
    Double[] latitude = {1.0, 26.93525776226133, 26.93567812127418, 26.935498185113538, 26.93559428485525, 26.936101625341077};
    Double[] longitude = {1.0, 75.92399261608922, 75.92398267670698, 75.9238010608476, 75.92369054981872, 75.92411008639891};

    RecyclerView recyclerView;
    List<location_details> location_detailsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.main_recycler_view);

        initdata();
        setRecyclerView();
    }

    private void initdata() {
        location_detailsList = new ArrayList<>();

        location_detailsList.add(new location_details(details[0], location[0], latitude[0], longitude[0], R.drawable.hostel_img));
        location_detailsList.add(new location_details(details[1], location[1], latitude[1], longitude[1], R.drawable.token_collection_img));
        location_detailsList.add(new location_details(details[2], location[2], latitude[2], longitude[2], R.drawable.doc_verification_img));
        location_detailsList.add(new location_details(details[3], location[3], latitude[3], longitude[3], R.drawable.credidantials_img));
        location_detailsList.add(new location_details(details[4], location[4], latitude[4], longitude[4], R.drawable.biometric_img));
        location_detailsList.add(new location_details(details[5], location[5], latitude[5], longitude[5], R.drawable.antiragging_img));
    }

    private void setRecyclerView() {
        recyclerviewAdapter adapter = new recyclerviewAdapter(MainActivity.this, location_detailsList);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }

    public void open_google_maps(double destLat, double destLng) {
        String uriString = String.format("https://www.google.com/maps/dir/?api=1&destination=%f,%f", destLat, destLng);
        Uri uri = Uri.parse(uriString);

        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(MainActivity.this, "Google Maps is not installed.", Toast.LENGTH_SHORT).show();
            // Optionally, open a web-based map service
            Intent webIntent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(webIntent);
        }
    }
}