package com.example.hipple.dto;

import lombok.*;

import java.time.LocalDateTime;

//response
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OcrResultResponse {
    private Long id;
    private String filename;
    private String extractedText;
    private LocalDateTime createdAt;
}