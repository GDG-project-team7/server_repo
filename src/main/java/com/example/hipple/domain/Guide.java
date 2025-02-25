package com.example.hipple.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Guide extends User {
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio; // Guide는 1개의 Portfolio를 가짐

    @OneToMany(mappedBy = "guide", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Form> forms = new ArrayList<>(); // Guide는 여러 개의 Form을 가짐

    private String textProfile;
    private String introduction;

    public Guide(String password, String userName, boolean isGuide, int regionId, String email, String phoneNumber, int birthday6Numbers, String textProfile, String introduction) {
        super(password, userName, true, regionId, email, phoneNumber, birthday6Numbers);
        this.textProfile = textProfile;
        this.introduction = introduction;
        this.portfolio = null; // ✅ Portfolio는 나중에 설정 가능
    }
}