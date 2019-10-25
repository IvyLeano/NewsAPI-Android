package com.example.newsfeed;

import org.json.JSONObject;

public class NewsData {
        private String id;
        private String name;
        private String description;
        private String url;
        private String category;
        private String language;
        private String country;

        //Setter method
        public void setData(JSONObject object){
            try {
                this.id = object.getString("id");
                this.name = object.getString("name");
                this.description = object.getString("description");
                this.url = object.getString("url");
                this.category = object.getString("category");
                this.language = object.getString("language");
                this.category = object.getString("country");
            } catch(Exception e) {
                System.out.println("Logged from setData() in NewsData.java " + e);
            }
        }
        //Getter methods
        public String getId(){
            return this.id;
        }
        public String getName(){
            return this.name;
        }
        public String getDescription(){
            return this.description;
        }
        public String getUrl(){
            return this.url;
        }
        public String getCategory(){
            return this.category;
        }
        public String getLanguage(){
            return this.language;
        }
        public String getCountry(){
            return this.country;
        }
    }
