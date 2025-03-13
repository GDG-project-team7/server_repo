package com.example.hipple.controller;

import com.example.hipple.domain.Form;
import com.example.hipple.domain.Guide;
import com.example.hipple.domain.Portfolio;
import com.example.hipple.repository.GuideRepository;
import com.example.hipple.service.FormService;
import com.example.hipple.service.GuideService;
import com.example.hipple.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guidePage")
@RequiredArgsConstructor
public class GuidePageController {
    private final UserService userService;
    private final FormService formService;
    private final GuideService guideService;

    //지역ID로 가이드 리스트 조회
    @GetMapping("/getGuidesByRegionId/{regionId}")
    public List<Guide> getGuidesByRegionId(@PathVariable Long regionId) {
        return guideService.findGuidesByRegionId(regionId);
    }

    //가이드의 이름 보기
    @GetMapping("/getGuideName/{id}")
    public String getGuideName(@PathVariable Long id) {
        return userService.getInfoGuideName(id);
    }


    //가이드가 가지고 있는 견적서 리스트 확인
    @GetMapping("/{guideId}/getForms")
    public List<Form> getGuideForms(@PathVariable Long guideId) {
        return userService.getForms(guideId);
    }

    //견적서 클릭 시, 하나의 견적서 보기
    @GetMapping("/{formId}/getForm")
    public Form getForm(@PathVariable Long formId) {
        return formService.getForm(formId);
    }

}
