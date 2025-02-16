package com.example.hipple.dto.request;

import lombok.Getter;

//회원가입 아이디, 비밀번호, 이름, 전화번호, 생년월일, 성별, 이메일
@Getter
public class SignUpRequestDTO {
    private String loginId;
    private String password;
    private String name;
    private Integer phoneNumber;
    private Integer age;
    private String gender;
    private String email;
}