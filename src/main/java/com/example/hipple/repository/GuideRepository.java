package com.example.hipple.repository;

import com.example.hipple.domain.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuideRepository extends JpaRepository<Guide, Long> {
//    List<Guide> findAllByRegionId(Long regionId);
//    Guide findGuideByForms_User_Id(Long travelerId);
}