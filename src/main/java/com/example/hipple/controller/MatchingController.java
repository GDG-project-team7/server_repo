package com.example.hipple.controller;

import com.example.hipple.domain.Form;
import com.example.hipple.domain.Guide;
import com.example.hipple.domain.Portfolio;
import com.example.hipple.domain.Traveler;
import com.example.hipple.repository.FormRepository;
import com.example.hipple.repository.GuideRepository;
import com.example.hipple.repository.TravelerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matching")
@RequiredArgsConstructor
public class MatchingController {
    private final GuideRepository guideRepository;
    private final TravelerRepository travelerRepository;
    private final FormRepository formRepository;

    // 2. Traveler가 Guide를 선택하고 Form을 제출
    @PostMapping("/{travelerId}/select-guide/{guideId}")
    public ResponseEntity<String> submitForm(
            @PathVariable Long travelerId,
            @PathVariable Long guideId,
            @RequestBody Form formRequest) {

        Traveler traveler = travelerRepository.findById(travelerId)
                .orElseThrow(() -> new RuntimeException("Traveler를 찾을 수 없습니다."));
        Guide guide = guideRepository.findById(guideId)
                .orElseThrow(() -> new RuntimeException("Guide를 찾을 수 없습니다."));

        Form form = new Form(formRequest.get(), traveler, guide);
        formRepository.save(form);

        return ResponseEntity.ok("Traveler의 Form이 Guide에게 전송되었습니다.");
    }

    // 3. Guide가 자신에게 온 Form 목록 조회
    @GetMapping("/{guideId}/forms")
    public List<Form> getGuideForms(@PathVariable Long guideId) {
        Guide guide = guideRepository.findById(guideId)
                .orElseThrow(() -> new RuntimeException("Guide를 찾을 수 없습니다."));

        return guide.getForms();
    }

    // 4. Guide가 특정 Traveler의 Form을 조회
    @GetMapping("/{guideId}/form/{travelerId}")
    public Form getTravelerForm(
            @PathVariable Long guideId,
            @PathVariable Long travelerId) {

        Guide guide = guideRepository.findById(guideId)
                .orElseThrow(() -> new RuntimeException("Guide를 찾을 수 없습니다."));
        return guide.getForms().stream()
                .filter(form -> form.getTraveler().getId().equals(travelerId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("해당 Traveler의 Form이 없습니다."));
    }
}
}
