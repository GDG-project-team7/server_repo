package com.example.hipple.controller;

import com.example.hipple.domain.Form;
import com.example.hipple.repository.GuideFormRepository;
import com.example.hipple.service.FormService;
import com.example.hipple.service.GuideFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/form")
@RequiredArgsConstructor
public class FormController {
    private final FormService formService;
    private final GuideFormService guideFormService;

    @PostMapping("/{userId}/saveForm")
    public String saveForm(@PathVariable Long userId, @RequestBody Form form) {
        formService.saveForm(form);
        return "ok";
    }

    @GetMapping("/{userId}/getForms")
    public ResponseEntity<List<Form>> getForms(@PathVariable Long userId) {
        return ResponseEntity.ok().body(formService.getForms(userId));
    }

    @GetMapping("/{userId}/getGuideForms")
    public ResponseEntity<List<Form>> getGuideForms(@PathVariable Long userId) {
        return ResponseEntity.ok().body(guideFormService.getForms(userId));
    }
}