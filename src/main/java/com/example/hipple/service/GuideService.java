package com.example.hipple.service;

import com.example.hipple.domain.Guide;
import com.example.hipple.domain.Portfolio;
import com.example.hipple.repository.GuideRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuideService {
    private final GuideRepository guideRepository;

    public Guide saveGuide(Guide guide){
        guideRepository.save(guide);
        return guide;
    }

    @Transactional
    public Portfolio savePortfolio(Long guideId, Portfolio portfolio){
        Guide guide = guideRepository.findById(guideId)
                .orElseThrow(() -> new EntityNotFoundException("Guide not found"));

        guide.setPortfolio(portfolio);
        guideRepository.save(guide);

        return portfolio;
    }
}
