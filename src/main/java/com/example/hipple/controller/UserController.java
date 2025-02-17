package com.example.hipple.controller;

import com.example.hipple.dto.request.UserLogin;
import com.example.hipple.dto.request.UserSignUp;
import com.example.hipple.dto.response.TokenDto;
import com.example.hipple.dto.response.UserInfo;
import com.example.hipple.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserInfo> saveUser(@RequestBody UserSignUp userSignUp) {
        return ResponseEntity.ok().body(userService.saveUser(userSignUp));
    }

    @GetMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody UserLogin userLogin) {
        return ResponseEntity.ok().body(userService.loginUser(userLogin));
    }

    @GetMapping
    public ResponseEntity<UserInfo> getUser(Principal principal) {
        return ResponseEntity.ok().body(userService.getUser(principal));
    }
}