package com.example.hipple.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String profileText;
    private String travelPlace;
    private String foodPlace;
    private String photoPlace;

    public Portfolio(String title,String profileText, String travelPlace, String foodPlace, String photoPlace) {
        this.title = title;
        this.travelPlace = travelPlace;
        this.foodPlace = foodPlace;
        this.photoPlace = photoPlace;
    }
}
