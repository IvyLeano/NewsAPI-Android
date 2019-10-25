package com.example.newsfeed;

import org.json.JSONObject;

public class NewsData {
        private String id;
        private String name;
        private String description;
        private String url;
        private String category;
        private String language;
        private String en;
        private String country;

    public void setData(JSONObject object){
        System.out.println("in setdata(): " + object + "************************");
    }
}
