package com.example.hipple.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Traveler extends User {
//
//    @OneToOne(mappedBy = "traveler", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Form form; // Traveler는 1개의 Form을 가질 수 있음
//
//    public Traveler(String password, String userName, String email, String phoneNumber, int birthday6Numbers, boolean isGuide, int regionId) {
//        super(password, userName, false, regionId, email, phoneNumber, birthday6Numbers);
//        this.form = null; // ✅ Form은 나중에 설정 가능
//    }
}
