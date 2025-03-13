package com.example.hipple.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // Hibernate 프록시 필드 무시
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
