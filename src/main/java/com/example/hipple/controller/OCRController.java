package com.example.hipple.controller;

import com.example.hipple.dto.OCRdto;
import com.example.hipple.service.OCRService;
import lombok.RequiredArgsConstructor;
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

    @PostMapping("/image")
    public ResponseEntity<OCRdto> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String result = ocrService.extractTextFromImage(file);
            return ResponseEntity.ok(new OCRdto(result));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new OCRdto("OCR 실패: " + e.getMessage()));
        }
    }
}
