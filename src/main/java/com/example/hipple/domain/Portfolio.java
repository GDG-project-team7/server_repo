package com.example.hipple.domain;

public class Portfolio {
    private String title;
    private String travelPlace;
    private String foodPlace;
    private String photoPlace;

    public Portfolio(String title, String travelPlace, String foodPlace, String photoPlace) {
        this.title = title;
        this.travelPlace = travelPlace;
        this.foodPlace = foodPlace;
        this.photoPlace = photoPlace;
    }
}
