package com.example.hipple.controller;

import com.example.hipple.domain.Guide;
import com.example.hipple.domain.Traveler;
import com.example.hipple.service.GuideService;
import com.example.hipple.service.TravelerService;
import com.example.hipple.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final TravelerService travelerService;
    private final GuideService guideService;

    @PostMapping("/saveGuide")
    public ResponseEntity<Guide> saveGuide(@RequestBody Guide guide) {
        return ResponseEntity.ok().body(guideService.saveGuide(guide));
    }

    @PostMapping("/saveTraveler")
    public ResponseEntity<Traveler> saveTraveler(@RequestBody Traveler traveler) {
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