package com.example.hipple.controller;

import com.example.hipple.domain.Guide;
import com.example.hipple.domain.Traveler;
import com.example.hipple.domain.User;
import com.example.hipple.service.TravelerService;
import com.example.hipple.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.servlet.function.ServerResponse.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "로그인 페이지 API", description = "회원가입 로직 API입니다.")
public class UserController {

    private final UserService userService;
    private final TravelerService travelerService;

    @PostMapping("/saveGuide")
    public ResponseEntity<Long> saveUserGuide(@RequestBody Guide guide) {
        return ResponseEntity.ok().body(userService.saveUserGuide(guide));
    }

    //가이드 로그인 시,
    @PostMapping("/saveTraveler")
    public ResponseEntity<Traveler> saveUserGuide(@RequestBody Traveler traveler) {
        return ResponseEntity.ok().body(userService.saveUserTraveler(traveler));
    }

    @GetMapping("/getTraveler/{travelerId}")
    public ResponseEntity<User> getUserTraveler(@PathVariable Long travelerId) {
        return ResponseEntity.ok().body(userService.getUserTraveler(travelerId));
    }

//
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