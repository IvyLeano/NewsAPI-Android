package com.example.newsfeed;
import java.util.Vector;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

public class NewsRestApi {

    NewsData[] newsData;

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
                try {
                    populateNewsDataArray(response.getJSONArray("sources"));
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
      return jsonObjectRequest;
    }

    public void populateNewsDataArray(JSONArray objects){
        for(int i = 0; i < objects.length(); i++){
            NewsData newsData = new NewsData();
            try {
                newsData.setData(objects.getJSONObject(i));
                this.newsData[i] = newsData;
            } catch (Exception e){
                System.out.println("Logged from populateNewsDataArray() in NewsRestApi.java: " + e);
            }
        }
    }

    public void getNewsDataArray(){
        for(int i = 0; i < newsData.length; i++){
            System.out.println("************ id: " + newsData[i].getId());
        }
    }
}
