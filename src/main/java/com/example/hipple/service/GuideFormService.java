package com.example.hipple.service;

import com.example.hipple.domain.Form;
import com.example.hipple.repository.FormRepository;
import com.example.hipple.repository.GuideFormRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuideFormService {
    private GuideFormRepository guideFormRepository;

    public void saveForm(Form form){
        guideFormRepository.save(form);
    }

    public List<Form> getForms(Long userId){
        return guideFormRepository.findAllByUserId(userId);
    }
}
