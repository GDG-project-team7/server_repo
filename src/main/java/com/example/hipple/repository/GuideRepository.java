package com.example.hipple.repository;

import com.example.hipple.domain.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GuideRepository extends JpaRepository<Guide, Long> {
    List<Guide> findAllByRegionId(Long regionId);

//    Guide findByForms_User_Id(Long travelerId);

}