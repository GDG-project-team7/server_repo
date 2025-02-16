package com.example.hipple.controller;

import com.example.hipple.dto.request.SignInRequestDTO;
import com.example.hipple.dto.response.SignInResponseDTO;
import com.example.hipple.service.LoginService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {
    private LoginService loginService;

    //회원가입

    //로그인
    @PostMapping("/sign-in")
    public SignInResponseDTO siginIn(@RequestBody SignInRequestDTO req){
        SignInResponseDTO res = loginService.signIn(req);
        return res;
    }

    //로그인 테스트
}
