package com.example.hipple.domain;

public class Form {
    private Long age;
    private boolean gender;
    private String text;
    private Long TravelDate;

    public Form(Long age, boolean gender, String text, Long TravelDate) {
        this.age = age;
        this.gender = gender;
        this.text = text;
        this.TravelDate = TravelDate;
    }
}
