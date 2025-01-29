package com.example.hipple.dto;

public class KakaoUserInfo {
    private Long id;
    private Properties properties;
    private KakaoAccount kakao_account;

    // Getters and Setters

    public static class Properties {
        private String nickname;
        private String profile_image;
        private String thumbnail_image;

        // Getters and Setters
    }

    public static class KakaoAccount {
        private String email;
        private Boolean is_email_verified;
        private String gender;
        private String birthyear;
        private String birthday;

        // Getters and Setters
    }
}
