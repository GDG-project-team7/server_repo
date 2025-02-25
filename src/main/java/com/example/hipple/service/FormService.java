package com.example.hipple.service;

import com.example.hipple.domain.Form;
import com.example.hipple.domain.Guide;
import com.example.hipple.domain.Traveler;
import com.example.hipple.repository.FormRepository;
import com.example.hipple.repository.GuideRepository;
import com.example.hipple.repository.TravelerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FormService {
    private final FormRepository formRepository;
    private final GuideRepository guideRepository;
    private final TravelerRepository travelerRepository;

    public Form getForm(Long id) {
        return formRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 견적서를 찾을 수 없습니다."));
    }

    public String submitForm(Long travelerId, Long guideId, Form formRequest) {
        Traveler traveler = travelerRepository.findById(travelerId)
                .orElseThrow(() -> new RuntimeException("Traveler를 찾을 수 없습니다."));
        Guide guide = guideRepository.findById(guideId)
                .orElseThrow(() -> new RuntimeException("Guide를 찾을 수 없습니다."));

        //Long age, boolean gender, String text, Long travelDate, Guide guide, Traveler traveler
        Form form = new Form(formRequest.getAge(), formRequest.isGender(), formRequest.getText(), formRequest.getTravelDate(), "pending", guide, traveler);
        formRepository.save(form);

        return "해당 견적서가 가이드에게 요청되었습니다.";
    }

    public int getPendingFormsCountByGuideId(Long guideId) {
        return formRepository.findByGuide_UserIdAndIsAccepted(guideId, "pending").size();
    }

    @Transactional
    public String acceptFormStatus(Long formId) {
        Form form = formRepository.findById(formId)
                .orElseThrow(() -> new RuntimeException("해당 견적서를 찾을 수 없습니다."));

        form.setIsAccepted("Accept");
        return "성공적으로 수락되었습니다.";
    }

    @Transactional
    public String rejectForm(Long formId) {
        formRepository.deleteById(formId);
        return "견적서를 거절하였습니다.";
    }
}