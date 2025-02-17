package com.example.hipple.repository;

import com.example.hipple.domain.Form;
import com.example.hipple.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
