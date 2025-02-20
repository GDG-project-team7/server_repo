package com.example.hipple.service;

import com.example.hipple.domain.*;
import com.example.hipple.repository.GuideRepository;
import com.example.hipple.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final GuideRepository guideRepository;


    public Guide saveUserGuide(Guide guide) {
        userRepository.save(guide);
        return guide;
    }

    public Traveler saveUserTraveler(Traveler traveler) {
        userRepository.save(traveler);
        return traveler;
    }

    public String getInfoGuideName(Long id) {
        return userRepository.findById(id)
                .map(User::getUserName) // User 엔티티에서 name 필드 가져오기
                .orElseThrow(() -> new RuntimeException("가이드를 찾을 수 없습니다."));
    }
    public Portfolio getInfoGuidePortfolio(Long id) {
        return guideRepository.findById(id)
                .map(Guide::getPortfolio)
                .orElseThrow(() -> new RuntimeException("포트폴리오를 작성하지 않았습니다."));
    }

    public Portfolio saveInfoGuidePortfolio(Long id, Portfolio portfolio) {
        Guide guide = guideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("가이드를 찾을 수 없습니다."));
        guide.setPortfolio(portfolio); // ✅ 포트폴리오 설정
        guideRepository.save(guide);

        return guide.getPortfolio();
    }

//    public List<Form> getForms(Long id) {
//        Guide guide = guideRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("가이드를 찾을 수 없어 견적서 조회가 불가능합니다."));
//        return guide.getForms();
//    }
}
