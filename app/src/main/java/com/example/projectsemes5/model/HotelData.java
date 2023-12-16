package com.example.projectsemes5.model;

public class HotelData {
    String id, name, location;
    Integer price, imageUrl;
    Double rating;

    public HotelData(String id, String name, String location, Integer price, Integer imageUrl, Double rating) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.price = price;
        this.imageUrl = imageUrl;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public HotelData(){

    }
}
