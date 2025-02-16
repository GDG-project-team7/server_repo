package com.example.hipple.domain;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//로그인 도메인
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_loginid")
    private String loginId; //로그인 할 때 쓰는 아이디
    @Column(name = "user_password")
    private String password; //로그일 할 때 쓰는 비번
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_age")
    private Integer age;
    @Column(name = "user_portfolio")
    private String portfolio;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public Login(Long id, String portfolio, String loginId, String password, String name, Integer age){
        this.id=id;
        this.portfolio=portfolio;
        this.loginId=loginId;
        this.password=password;
        this.age = age;
        this.name =name;
        this.role = Role.GUIDE;
        this.role = Role.TRAVELER;
    }
}
