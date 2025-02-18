package com.example.hipple.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Test")
@Tag(name = "test", description = "테스트용")
public class TestController {
    @GetMapping
    public String test() {
        return "successssssssssssssssssssssssss";
    }
}
