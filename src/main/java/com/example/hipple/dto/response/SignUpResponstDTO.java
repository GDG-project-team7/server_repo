package com.example.hipple.dto.response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

//회원가입한 내용을 클라이언트에 전달
@Getter
@Builder
@AllArgsConstructor
public class SignUpResponstDTO {
    private String loginId;
    private String password;
    private String name;
    private Integer phoneNumber;
    private Integer age;
    private String gender;
    private String email;
    private String role;
}
