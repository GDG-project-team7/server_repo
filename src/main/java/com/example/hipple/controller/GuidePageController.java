package com.example.hipple.controller;

import com.example.hipple.domain.Form;
import com.example.hipple.domain.Guide;
import com.example.hipple.domain.Portfolio;
import com.example.hipple.repository.GuideRepository;
import com.example.hipple.service.FormService;
import com.example.hipple.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guidePage")
@RequiredArgsConstructor
@Tag(name = "가이드 페이지 API", description = "가이드 측면의 로직 API입니다.")
public class GuidePageController {
    private final UserService userService;
    private final FormService formService;

    //가이드의 이름 보기
    @GetMapping("/getGuideName/{id}")
    public String getGuideName(@PathVariable Long id) {
        return userService.getInfoGuideName(id);
    }

    @GetMapping("/getNewFormCount/{guideId}")
    public int getNewFormCount(@PathVariable Long guideId) {
        return formService.getPendingFormsCountByGuideId(guideId);
    }

    @GetMapping("/getGuideInfo/{id}")
    public Guide getGuideInfo(@PathVariable Long id) {
        return userService.getUserGuide(id);
    }

    //가이드의 포트폴리오 보기
    @GetMapping("/getGuidePortfolio/{id}")
    public Portfolio getGuidePortfolio(@PathVariable Long id) {
        return userService.getInfoGuidePortfolio(id);
    }

    //가이드의 포트폴리오 저장
    @PostMapping("/saveGuidePortfolio/{id}")
    public Portfolio saveGuidePortfolio(@PathVariable Long id, @RequestBody Portfolio portfolio) {
        return userService.saveInfoGuidePortfolio(id, portfolio);
    }

    //Pending상태인 견적서 보기
    @GetMapping("/{guideId}/getPendingForms")
    public List<Form> getGuideForms(@PathVariable Long guideId) {
        return userService.getForms(guideId);
    }
    //accept상태인 견적서 보기


    //견적서 클릭 시, 하나의 견적서 보기
    @GetMapping("/{formId}/getForm")
    public Form getForm(@PathVariable Long formId) {
        return formService.getForm(formId);
    }

}
