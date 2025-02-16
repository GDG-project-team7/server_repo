package com.example.hipple.repository;
import com.example.hipple.domain.Sign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SignUpRepository extends JpaRepository<Sign, Long> {
    Optional<Sign> findBySignId(String loginId);
    Optional<Sign> save(String loginId);
}
