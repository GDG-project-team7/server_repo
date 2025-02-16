package com.example.hipple.service;

import com.example.hipple.domain.Sign;
import com.example.hipple.dto.request.SignUpRequestDTO;
import com.example.hipple.dto.response.SignUpResponstDTO;
import com.example.hipple.dto.response.TokenDto;
import com.example.hipple.jwt.TokenProvider;
import com.example.hipple.repository.SignUpRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpService {
    private final SignUpRepository signUpRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    @Transactional
    public TokenDto signUp(SignUpRequestDTO req) {
        Sign sign = signUpRepository.save(Sign.builder()
                .email(req.getEmail())
                .password(passwordEncoder.encode(req.getPassword()))
                .phoneNumber(req.getPhoneNumber())
                .build());

        String accessToken = tokenProvider.createAccessToken(sign);

        return TokenDto.builder()
                .accessToken(accessToken)
                .build();
    }

    @Transactional(readOnly = true)
    public SignUpResponstDTO findByPrincipal(Principal principal) {
        Long userId = Long.parseLong(principal.getName());

        Sign sign = signUpRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        return SignUpResponstDTO.builder()
                .email(sign.getEmail())
                .phoneNumber(sign.getPhoneNumber())
                .role(sign.getRole().name())
                .build();
    }
}
}
