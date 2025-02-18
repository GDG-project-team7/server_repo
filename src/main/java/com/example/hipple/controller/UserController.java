package com.example.hipple.controller;

import com.example.hipple.domain.Guide;
import com.example.hipple.domain.Traveler;
import com.example.hipple.domain.User;
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

    @PostMapping("/saveGuide")
    public ResponseEntity<Guide> saveUserGuide(@RequestBody Guide guide) {
        return ResponseEntity.ok().body(userService.saveUserGuide(guide));
    }

    @PostMapping("/saveTraveler")
    public ResponseEntity<Traveler> saveUserGuide(@RequestBody Traveler traveler) {
        return ResponseEntity.ok().body(userService.saveUserTraveler(traveler));
    }


//    @GetMapping("/login")
//    public ResponseEntity<TokenDto> login(@RequestBody UserLogin userLogin) {
//        return ResponseEntity.ok().body(userService.loginUser(userLogin));
//    }
//
//    @GetMapping
//    public ResponseEntity<UserInfo> getUser(Principal principal) {
//        return ResponseEntity.ok().body(userService.getUser(principal));
//    }
}