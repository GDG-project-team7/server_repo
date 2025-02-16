package com.example.hipple.domain;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//회원가입 도메인
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Sign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_loginid")
    private String loginId; //회원가입 아이디
    @Column(name = "user_password")
    private String password; //회원가입 비번
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_phone_number")
    private Integer phoneNumber;
    @Column(name = "user_age")
    private Integer age;
    @Column(name = "user_gender")
    private String gender;
    @Column(name = "user_email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private Role role;

    @Builder
    public Sign(Long id, Integer phoneNumber, String gender, String email, String loginId, String password, String name, Integer age){
        this.id=id;
        this.loginId=loginId;
        this.password=password;
        this.age = age;
        this.name =name;
        this.phoneNumber=phoneNumber;
        this.gender=gender;
        this.email=email;
        this.role = Role.TRAVELER;
        this.role = Role.GUIDE;
    }
}
