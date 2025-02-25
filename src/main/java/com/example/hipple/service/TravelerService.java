package com.example.hipple.service;

import com.example.hipple.domain.Guide;
import com.example.hipple.domain.Traveler;
import com.example.hipple.repository.GuideRepository;
import com.example.hipple.repository.TravelerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TravelerService {
    private final GuideRepository guideRepository;
    private final TravelerRepository travelerRepository;

    public List<Guide> getRegionGuide(Long regionId){
        return guideRepository.findAllByRegionId(regionId);
    }

//    public Guide getMatchingGuide(Long travelerId){
//        return guideRepository.findByForms_User_Id(travelerId);
//    }
}
