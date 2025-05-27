package com.example.hipple.controller;

import com.example.hipple.dto.OcrResultResponse;
import com.example.hipple.service.OCRService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ocr")
public class OCRController {

    private final OCRService ocrService;

    // POST /ocr/upload
    @PostMapping("/upload")
    public ResponseEntity<OcrResultResponse> extractText(@RequestParam("file") MultipartFile file) {
        try {
            OcrResultResponse result = ocrService.extractTextFromImage(file);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    // GET /ocr/{id}
    @GetMapping("/{id}")
    public ResponseEntity<OcrResultResponse> getOcrResult(@PathVariable Long id) {
        OcrResultResponse response = ocrService.getOcrResultById(id);
        return response != null
                ? ResponseEntity.ok(response)
                : ResponseEntity.notFound().build();
    }
}