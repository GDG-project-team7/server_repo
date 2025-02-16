package com.example.hipple.controller;

import com.example.hipple.dto.request.SignUpRequestDTO;
import com.example.hipple.dto.response.SignUpResponstDTO;
import com.example.hipple.dto.response.TokenDto;
import com.example.hipple.service.SignUpService;
import com.example.hipple.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/gdg")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class SignController {
    private final SignUpService signUpService;

    @PostMapping("/signUp")
    public ResponseEntity<TokenDto> signUp(@RequestBody SignUpRequestDTO req) {
        TokenDto response = signUpService.signUp(req);

        return ResponseEntity.ok(response);
    }

    //회원가입 테스트
    @GetMapping("/getUser")
    public ResponseEntity<SignUpResponstDTO> getUser(Principal principal) {
        SignUpResponstDTO signUpResponstDTO = signUpService.findByPrincipal(principal);

        return ResponseEntity.ok(signUpResponstDTO);
    }
}