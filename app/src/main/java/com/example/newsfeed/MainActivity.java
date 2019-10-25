package com.example.newsfeed;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        String baseUrl = "https://newsapi.org/v2/sources?language=en&apiKey=";
        String api = "ea59d14adf274f3294daa1fbae58ae92";

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
                Log.e("Rest Response", response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Rest Response", error.toString());
            }
        }
        );
        // 3. add request to request queue
        requestQueue.add(jsonObjectRequest);
    }
}
