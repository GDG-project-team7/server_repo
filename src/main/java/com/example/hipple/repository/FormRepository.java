package com.example.hipple.repository;

import com.example.hipple.domain.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form, Long> {
}
