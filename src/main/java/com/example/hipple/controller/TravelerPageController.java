package com.example.hipple.controller;

import com.example.hipple.domain.Guide;
import com.example.hipple.service.TravelerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/travelerPage")
@RequiredArgsConstructor
@Tag(name = "여행자 페이지 API", description = "여행자 측면의 로직 API입니다.")
public class TravelerPageController {
    private final TravelerService travelerService;

    // 각 지역의 가이드들을 검색합니다.
    @GetMapping("/getRegionGuideList")
    public ResponseEntity<List<Guide>> guideListByRegionId(Long regionId){
        return ResponseEntity.ok().body(travelerService.getRegionGuide(regionId));
    }
}
