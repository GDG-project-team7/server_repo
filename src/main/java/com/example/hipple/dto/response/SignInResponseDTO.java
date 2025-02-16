package com.example.hipple.dto.response;
import com.example.hipple.domain.Role;
import lombok.Builder;

@Builder
//로그인 성공 -> 고유 id, 이름, 활동명, 포트폴리오, 나이 받기
public class SignInResponseDTO {
    private Long id;
    private String name;
    private String portfolio;
    private String nickname;
    private Integer age;
    private Role role;
}