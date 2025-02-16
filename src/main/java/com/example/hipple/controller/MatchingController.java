package com.example.hipple.controller;

import com.example.hipple.domain.Form;
import com.example.hipple.service.FormService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/match")
@RequiredArgsConstructor
public class MatchingController {

    private final FormService formService;

    @PostMapping("/{userId}/saveForm")
    public String saveForm(@PathVariable Long userId, @RequestBody Form form) {
        formService.saveForm(form);
        return "ok";
    }

}
