package com.example.newsfeed;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Layout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.net.Uri;
import android.view.View;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Vector;

import android.widget.TextView;

import com.squareup.picasso.Picasso;
import android.content.Intent;

import android.widget.LinearLayout.LayoutParams;

public class ScrollingActivity extends AppCompatActivity {

    public String baseUrl = "https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=";
    public String api = "ea59d14adf274f3294daa1fbae58ae92";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 3 tasks to call a REST API
        // 1. create a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        // 2. construct request
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, baseUrl + api, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    // 2.a. response logic - store response to a vector array
                    Vector newsData = new Vector();
                    JSONArray array = response.getJSONArray("articles");

                    for (int i = 0; i < array.length(); i++) {
                        NewsData news = new NewsData();
                        news.setData(array.getJSONObject(i));
                        newsData.add(news);
                    }
                    setView(newsData);
                } catch (Exception e) {
                    System.out.println("Logged from JsonObjectRequest() in NewsRestApi.java: " + e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        });
        // 3. add request to request queue
        requestQueue.add(jsonObjectRequest);
    }

    public void setView(Vector data) {
        LinearLayout linearLayout = findViewById(R.id.linear_layout);

        for (int i = 0; i < data.size(); i++) {
            final NewsData newsData = (NewsData) data.get(i);

            TextView title = new TextView(this);
            title.setText(newsData.getTitle());
            title.setTextSize(14);
            title.setTextColor(Color.BLACK);
//            title.setTypeface(null, Typeface.BOLD);
            linearLayout.addView(title);

            TextView author = new TextView(this);
            author.setText(newsData.getName() + ", " + newsData.getAuthor());
            author.setTextSize(12);
            linearLayout.addView(author);

            ImageView imageView = new ImageView(this);
            Picasso.get().load(newsData.getUrlToImage()).into(imageView);
            linearLayout.addView(imageView);

            TextView description = new TextView(this);
            description.setText(newsData.getDescription());
            linearLayout.addView(description);

            Button more = new Button(this);
            more.setText("Read More");

            more.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    Intent viewIntent =
                            new Intent("android.intent.action.VIEW",
                                    Uri.parse(newsData.getUrl()));
                    startActivity(viewIntent);
                }
            });
            linearLayout.addView(more);

        }
    }
}






