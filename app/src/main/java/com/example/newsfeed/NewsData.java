package com.example.newsfeed;

import org.json.JSONObject;

public class NewsData {
        private String id;
        private String title;
        private String name;
        private String author;
        private String urlToImage;
        private String description;
        private String url;

        //Setter method
        public void setData(JSONObject object){
            try {
                this.id = object.getJSONObject("source").getString("id");
                this.title = object.getString("title");
                this.name = object.getJSONObject("source").getString("name");
                this.author = object.getString("author");
                this.urlToImage = object.getString("urlToImage");
                this.description = object.getString("description");
                this.url = object.getString("url");
            } catch(Exception e) {
                System.out.println("Logged from setData() in NewsData.java " + e);
            }
        }
        //Getter methods
        public String getId(){
            return this.id;
        }
        public String getTitle(){
        return this.title;
        }
        public String getName(){
            return this.name;
        }
        public String getAuthor(){ return this.author; }
        public String getUrlToImage(){ return this.urlToImage; }
        public String getDescription(){
        return this.description;
    }
        public String getUrl(){ return this.url; }
    }
