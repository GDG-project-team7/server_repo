package com.example.hipple.service;

import com.example.hipple.domain.Form;
import com.example.hipple.repository.FormRepository;
import org.springframework.stereotype.Service;

@Service
public class FormService {

    private FormRepository formRepository;

    public void save(Form form){
        formRepository.save(form);
    }
}