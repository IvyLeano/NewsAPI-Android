package com.example.newsfeed;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
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

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
                //method, endpoint (where the data is coming from), input parameter object type,
                //callback method, error response
                Request.Method.GET, baseUrl + api, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    // Store response to a vector array
                    Vector newsData = new Vector();
                    JSONArray array = response.getJSONArray("articles");

                    for(int i = 0; i < array.length(); i++){
                        try {
                            NewsData news = new NewsData();
                            news.setData(array.getJSONObject(i));
                            newsData.add(news);
                        } catch (Exception e){
                            System.out.println("Logged from populateNewsDataArray() in NewsRestApi.java: " + e);
                        }
                    }
                    setView(newsData);
                } catch (Exception e){
                    System.out.println("Logged from JsonObjectRequest() in NewsRestApi.java: " + e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        }
        );
        // 3. add request to request queue
        requestQueue.add(jsonObjectRequest);
    }
    public void setView(Vector data){


    }
}






