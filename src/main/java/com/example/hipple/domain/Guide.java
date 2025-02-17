package com.example.hipple.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Guide extends User {
    private Portfolio portfolio;
    private String textProfile;
    private String introduction;

    // Guide 생성자: User 클래스의 생성자를 호출하여 필드를 설정
    public Guide(String password, String userName, boolean isGuide, int regionId, String email, String phoneNumber, int birthday6Numbers, Portfolio portfolio, String textProfile, String introduction) {
        super(password, userName, true, regionId, email, phoneNumber, birthday6Numbers); // isGuide는 true로 설정
        this.portfolio = null;
        this.textProfile = textProfile;
        this.introduction = introduction;

    }
}
