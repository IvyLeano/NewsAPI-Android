package com.example.newsfeed;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ScrollingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 3 tasks to call a REST API
        // 1. create a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        // 2. construct request - code found in newsRestApi.getNews()
        NewsRestApi newsRestApi = new NewsRestApi();
        JsonObjectRequest jsonObjectRequest = newsRestApi.getNews();

        // 3. add request to request queue
        requestQueue.add(jsonObjectRequest);

        // Creating Views
//        for(int i = 0; i < newsRestApi.getNewsDataArray().size(); i++) {
//
//            NewsData newsData = (NewsData)newsRestApi.getNewsDataArray().get(i);
//            System.out.println("!!!!!!!!!!!!!!!! " + newsData.);
//
//            // 1. create a LinearLayout
//            LinearLayout layout = new LinearLayout(this);
//
//            // 2. create a TextView for the heading
//            TextView heading = new TextView(this);
//            heading.setText(newsData.getTitle());
//
//            // 3. add TextView to LinearLayout
//            layout.addView(heading);
//
//            // 4. add LinearLayout to ContentView
//            setContentView(layout);
//        }
    }
}
