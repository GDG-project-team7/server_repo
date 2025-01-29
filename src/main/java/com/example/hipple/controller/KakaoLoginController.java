package com.example.hipple.controller;

import com.example.hipple.dto.KakaoUserInfo;
import com.example.hipple.service.KakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

//인가 코드 받기, 토큰 받기, 사용자 로그인 처리 과정 수행
@RestController
@RequiredArgsConstructor
@RequestMapping("/callback")
public class KakaoLoginController {
    //authorization code - 테스트용
//    @GetMapping
//    public String kakaoLogin(@RequestParam("code")String code){
//        return code;
//    }
    private final KakaoService kakaoService;

    // 액세스 토큰을 받아오는 역할(테스트용)
    @GetMapping
    public String kakaoLogin(@RequestParam("code") String code) {
        String accessToken = kakaoService.getAccessToken(code);
        return "액세스 토큰 받아오기 성공 ! 액세스 토큰: " + accessToken;
    }

    // 사용자 정보를 받아오는 역할 (테스트용)
//    @GetMapping
//    public KakaoUserInfo kakaoLogin(@RequestParam("code") String code) {
//        String accessToken = kakaoService.getAccessToken(code);
//        KakaoUserInfo userInfo = kakaoService.getUserInfo(accessToken);
//        System.out.println("사용자 정보 받아오기 성공 !");
//        return userInfo;
//    }

    // 로그인 및 회원가입
    @GetMapping
    public Token kakaoLogin(@RequestParam("code") String code) {
        String kakaoAccessToken = kakaoService.getAccessToken(code);
        Token token = kakaoService.loginOrSignUp(kakaoAccessToken);
        System.out.println("로그인 성공 !");
        return token;
    }
}