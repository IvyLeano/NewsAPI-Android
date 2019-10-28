package com.example.newsfeed;
import android.os.Bundle;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import org.json.JSONArray;
import org.json.JSONObject;
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
                Request.Method.GET, baseUrl + api, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    // 2.a. response logic - store response to a vector array
                    Vector newsData = new Vector();
                    JSONArray array = response.getJSONArray("articles");

                    for(int i = 0; i < array.length(); i++){
                            NewsData news = new NewsData();
                            news.setData(array.getJSONObject(i));
                            newsData.add(news);
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
        });
        // 3. add request to request queue
        requestQueue.add(jsonObjectRequest);
    }
    public void setView(Vector data){


    }
}






