package com.example.hipple.controller;

import com.example.hipple.service.OCRService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("ocr")
public class OCRController {

    private final OCRService ocrService;

    @PostMapping("/upload")
    public ResponseEntity<String> extractText(@RequestParam("file") MultipartFile file) {
        try {
            String result = ocrService.extractTextFromImage(file);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("OCR 실패: " + e.getMessage());
        }
    }
}
