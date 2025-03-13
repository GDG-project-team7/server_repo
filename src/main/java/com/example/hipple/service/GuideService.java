package com.example.hipple.service;

import com.example.hipple.domain.Guide;
import com.example.hipple.repository.GuideRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuideService {
    private final GuideRepository guideRepository;

    public List<Guide> findGuidesByRegionId(Long regionId) {
        return guideRepository.findAllByRegionId(regionId);
    }

    public String saveGuide(Guide guide){
        guideRepository.save(guide);
        return "회원가입이 완료되었습니다.";
    }
}
