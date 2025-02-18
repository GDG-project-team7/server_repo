package com.example.hipple.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Form 엔티티의 고유 ID

    @ManyToOne(fetch = FetchType.LAZY)  // 여러 개의 Form이 하나의 Guide에 속함
    @JoinColumn(name = "guide_id")  // Form 테이블에서 Guide를 참조하는 외래키
    private Guide guide;

    @OneToOne(fetch = FetchType.LAZY)  // 여러 개의 Form이 하나의 Traveler에 속함
    @JoinColumn(name = "traveler_id")  // Form 테이블에서 Traveler를 참조하는 외래키
    private Traveler traveler;

    private Long age;           // 나이
    private boolean gender;     // 성별 (true: 남성, false: 여성)
    private String text;        // 여행에 대한 텍스트 정보
    private Long travelDate;    // 여행 날짜 (여기서는 Long으로 표현, 실제로 Date타입이 필요할 수 있음)

    // Form 객체를 생성하는 생성자
    public Form(Long age, boolean gender, String text, Long travelDate, Guide guide, Traveler traveler) {
        this.age = age;
        this.gender = gender;
        this.text = text;
        this.travelDate = travelDate;
        this.guide = guide;      // Guide와 연관되도록 설정
        this.traveler = traveler;  // Traveler와 연관되도록 설정
    }
}