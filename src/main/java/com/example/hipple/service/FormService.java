package com.example.hipple.service;

import com.example.hipple.domain.Form;
import com.example.hipple.repository.FormRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormService {

    private FormRepository formRepository;

    public void saveForm(Form form){
        formRepository.save(form);
    }

    public List<Form> getForms(Long userId){
        return formRepository.findAllByUserId(userId);
    }
}