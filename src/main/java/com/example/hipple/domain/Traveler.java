package com.example.hipple.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@NoArgsConstructor
@Getter
@Entity //jpa가 관리하고, DB에 저장될 때에는 User의 어노테이션으로 인해 합쳐져서 저장됨
public class Traveler extends User {

    // Guide 생성자: User 클래스의 생성자를 호출하여 필드를 설정
    public Traveler(String userName, int regionId) {
        super(userName, false, regionId); // isGuide는 true로 설정
    }
}