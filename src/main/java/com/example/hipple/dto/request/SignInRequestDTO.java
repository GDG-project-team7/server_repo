package com.example.hipple.dto.request;
import lombok.Getter;

//로그인 아이디, 비번
@Getter
public class SignInRequestDTO {
    private String loginId;
    private String password;
}
