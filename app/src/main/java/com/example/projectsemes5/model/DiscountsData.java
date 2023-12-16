package com.example.projectsemes5.model;

public class DiscountsData {
    String placeName;
    String title;
    String description;

    Integer imageUrl;

    public DiscountsData(String placeName, String title, String description, Integer imageUrl) {
        this.placeName = placeName;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }
}
