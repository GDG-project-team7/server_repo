package com.example.hipple.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

//추상화된 객체, 직접 객체 생성을 하지 못하지만 extends한 하위 객체에서는 객체 생성 가능
//테이블에 User만 있으므로 @Entity와 @Id는 부모클래스인 user에게만
@NoArgsConstructor
@Entity
@Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_name")
    private String userName;

    private boolean isGuide;
    private boolean gender;
    private int regionId;
    private String email;
    private String phoneNumber;
    private int birthday6Numbers;
    private String userAccountName;


    public User(String password, String userName, boolean isGuide, int regionId, String email, String phoneNumber, int birthday6Numbers, String userAccountName, boolean gender) {
        this.password = password;
        this.userName = userName;
        this.isGuide = isGuide;
        this.regionId = regionId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthday6Numbers = birthday6Numbers;
        this.userAccountName = userAccountName;
        this.gender = gender;
    }
}
