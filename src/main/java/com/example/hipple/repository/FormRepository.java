package com.example.hipple.repository;

import com.example.hipple.domain.Form;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormRepository extends JpaRepository<Form, Long> {
    List<Form> findByGuide_UserIdAndIsAccepted(Long guideId, String isAccepted);

}
