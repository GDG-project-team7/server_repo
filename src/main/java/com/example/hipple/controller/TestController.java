package com.example.hipple.controller;

import com.example.hipple.domain.Form;
import com.example.hipple.domain.Guide;
import com.example.hipple.domain.Traveler;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Test")
@Tag(name = "test", description = "테스트용")
public class TestController {

    @GetMapping
    public String test() {
        return "successssssssssssssssssssssssss";
    }

    @GetMapping("/getGuideList")
    public List<Form> getGuideList() {
        return createForms();
    }

    public List<Form> createForms() {
        List<Form> forms = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            // ✅ Form 생성
            Form form = new Form(
                    20L + i,  // 나이
                    i % 2 == 0,  // 성별 (짝수면 true(남성), 홀수면 false(여성))
                    "I want to travel " + i, // 여행 관련 텍스트
                    System.currentTimeMillis() + (i * 100000L), // 여행 날짜
                    "PENDING" // 승인 여부 (PENDING, ACCEPTED, REJECTED 등)
            );

            forms.add(form);
        }

        return forms;
    }
}
