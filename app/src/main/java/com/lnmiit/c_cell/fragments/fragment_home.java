package com.lnmiit.c_cell.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.lnmiit.c_cell.PDF_display;
import com.lnmiit.c_cell.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class fragment_home extends Fragment {

    ListView list;
    private ArrayAdapter<String> adapter;
    private static final String URL = "https://notification-api-tau.vercel.app/messages";
    private ArrayList<String> messageTexts;
    CardView acad_timetable_card, bus_timeable_card, mess_menu_card, holidar_calendar_card;
    private static final int INTERVAL = 2000;
    private Handler handler;
    private Runnable runnable;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        acad_timetable_card = v.findViewById(R.id.fragment_home_acad_timetable);
        bus_timeable_card = v.findViewById(R.id.fragment_home_bus_timetable);
        mess_menu_card = v.findViewById(R.id.fragment_home_mess_menu);
        holidar_calendar_card = v.findViewById(R.id.fragment_home_holiday_calendar);
        list = v.findViewById(R.id.frag_home_notification_list);

        setCardClickListeners();


        messageTexts = new ArrayList<>();
        adapter = new ArrayAdapter<>(getContext(), R.layout.notification_layout, R.id.notification_text, messageTexts);
        list.setAdapter(adapter);


        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                fetchMessages();
                handler.postDelayed(this, INTERVAL);
            }
        };
        handler.post(runnable);

        return v;
    }

    private void setCardClickListeners() {
        acad_timetable_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PDF_display.class);
                intent.putExtra("pdfUrl", "https://drive.google.com/file/d/1jkpW4DYfNzAdfrpdEnLYwLENiSyE8UDN/view?usp=drive_link");
                intent.putExtra("operation", 0);
                startActivity(intent);
            }
        });

        bus_timeable_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PDF_display.class);
                intent.putExtra("pdfUrl", "https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/pdf/Bus_Time_Table.pdf?raw=true");
                intent.putExtra("operation", 1);
                startActivity(intent);
            }
        });

        mess_menu_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PDF_display.class);
                intent.putExtra("pdfUrl", "https://github.com/Counselling-Cell-LNMIIT/appResources/blob/main/pdf/Mess_Menu.pdf?raw=true");
                intent.putExtra("operation", 1);
                startActivity(intent);
            }
        });

        holidar_calendar_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PDF_display.class);
                intent.putExtra("pdfUrl", "https://drive.google.com/file/d/1xapw_p19zfN0rUFlBwme07kHWcE0VlUS/view?usp=drive_link");
                intent.putExtra("operation", 0);
                startActivity(intent);
            }
        });
    }

    private void fetchMessages() {
        RequestQueue queue = Volley.newRequestQueue(getContext());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray messages = response.getJSONArray("messages");

                            boolean isNewMessage = false;
                            for (int i = 0; i < messages.length(); i++) {
                                JSONObject message = messages.getJSONObject(i);
                                String text = message.getString("text");
                                if (!messageTexts.contains(text)) {
                                    messageTexts.add(text);
                                    isNewMessage = true;
                                }
                            }

                            if (isNewMessage) {
                                adapter.notifyDataSetChanged();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

        queue.add(jsonObjectRequest);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacks(runnable); // Stop the handler when the view is destroyed
    }
}