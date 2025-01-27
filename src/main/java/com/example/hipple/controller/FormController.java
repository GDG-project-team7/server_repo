package com.example.hipple.controller;

import com.example.hipple.domain.Form;
import com.example.hipple.service.FormService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/form")
@RequiredArgsConstructor
public class FormController {
    private final FormService formService;

    @PostMapping("/{userId}/save")
    public String saveForm(@PathVariable Long userId, @RequestBody Form form) {
        formService.save(form);
        return "ok";
    }
}