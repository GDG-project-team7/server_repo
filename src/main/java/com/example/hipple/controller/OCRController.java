package com.example.hipple.controller;

import com.example.hipple.dto.OcrResultResponse;
import com.example.hipple.service.OCRService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

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

    // 서버에 이미지 저장
    @PostMapping("/image/save")
    public ResponseEntity<String> saveImage(@RequestParam("file") MultipartFile file) {
        try {
            String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();

            // 절대경로 기준으로 uploads 디렉토리 생성
            String uploadDir = System.getProperty("user.dir") + "/uploads";
            Path uploadPath = Paths.get(uploadDir);

            Files.createDirectories(uploadPath); // 없으면 생성

            Path filePath = uploadPath.resolve(filename);
            file.transferTo(filePath.toFile());

            return ResponseEntity.ok("저장 완료: " + filename);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("저장 실패: " + e.getMessage());
        }
    }

}