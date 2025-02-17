package com.example.hipple.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Entity //jpa가 관리하고, DB에 저장될 때에는 User의 어노테이션으로 인해 합쳐져서 저장됨
public class Traveler extends User {
    private Form form;

    // Traveler 생성자: User 클래스의 생성자를 호출하여 필드를 설정
    public Traveler(String password, String userName,String email, String phoneNumber, int birthday6Numbers, boolean isGuide, int regionId, Form form) {
        super(password, userName, false, regionId, email, phoneNumber, birthday6Numbers); // isGuide는 false로 설정
        this.form = null;
    }
}
