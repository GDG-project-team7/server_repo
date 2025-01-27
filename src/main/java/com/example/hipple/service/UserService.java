package com.example.hipple.service;

import com.example.hipple.domain.Guide;
import com.example.hipple.domain.User;
import com.example.hipple.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void save(Guide guide) {
        userRepository.save(guide);
    }
}
