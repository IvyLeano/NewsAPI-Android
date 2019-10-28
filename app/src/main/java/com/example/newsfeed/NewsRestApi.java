package com.example.newsfeed;
import java.util.Vector;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

public class NewsRestApi {

    Vector newsData = new Vector();

    public JsonObjectRequest getNews(){

        String baseUrl = "https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=";
        String api = "ea59d14adf274f3294daa1fbae58ae92";

        // 2. construct request
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                //method, endpoint (where the data is coming from), input parameter object type,
                //callback method, error response
                Request.Method.GET, baseUrl + api, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    populateNewsDataArray(response.getJSONArray("articles"));
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
            try {
                NewsData newsData = new NewsData();
                newsData.setData(objects.getJSONObject(i));
                this.newsData.add(newsData);
            } catch (Exception e){
                System.out.println("Logged from populateNewsDataArray() in NewsRestApi.java: " + e);
            }
        }
        getNewsDataArray();
    }

    public Vector getNewsDataArray(){
        for(int i = 0; i < newsData.size(); i++){
            NewsData x = new NewsData();
            x = (NewsData) newsData.get(i);
        }
        return newsData;
    }
}
