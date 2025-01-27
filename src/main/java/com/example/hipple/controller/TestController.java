package com.example.hipple.controller;

import com.example.hipple.domain.Guide;
import com.example.hipple.domain.User;
import com.example.hipple.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TestController {

    private final UserService userService;

    @PostMapping("/test")
    public String test(@RequestBody Guide guide) {

        userService.save(guide);
        return "ok";
    }
}
