package com.example.hipple.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Guide extends User {

    // Guide 생성자: User 클래스의 생성자를 호출하여 필드를 설정
    public Guide(String userName, int regionId) {
        super(userName, true, regionId); // isGuide는 true로 설정
    }
}
