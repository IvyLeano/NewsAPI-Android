package com.example.newsfeed;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import android.util.Log;
import org.json.JSONObject;

public class NewsRestApi {
    public JsonObjectRequest getNews(){
        String baseUrl = "https://newsapi.org/v2/sources?language=en&apiKey=";
        String api = "ea59d14adf274f3294daa1fbae58ae92";

        // 2. construct request
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                //method, endpoint (where the data is coming from), input parameter object type,
                //callback method, error response
                Request.Method.GET, baseUrl + api, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("Rest Response", response.toString());
//                System.out.println(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Rest Response", error.toString());
//                System.out.println(error.toString());
            }
        }
        );
      return jsonObjectRequest;
    }
}
