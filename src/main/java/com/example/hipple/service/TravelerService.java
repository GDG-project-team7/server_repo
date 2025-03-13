package com.example.hipple.service;

import com.example.hipple.domain.Guide;
import com.example.hipple.domain.Portfolio;
import com.example.hipple.repository.GuideRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TravelerService {
    private final GuideRepository guideRepository;

    public List<Guide> getRegionGuide(Long regionId){
        List<Guide> guideList = new ArrayList<>();
        guideList = guideRepository.findAllByRegionId(regionId);

        return guideList;
    }

    public Guide getGuide(Long guideId){
        return guideRepository.findById(guideId)
                .orElseThrow(RuntimeException::new);
    }

    public Portfolio getPortfolioByGuideId(Long guideId){
        Guide guide = getGuide(guideId);
        Portfolio portfolio = guide.getPortfolio();

        return portfolio;
    }
}
