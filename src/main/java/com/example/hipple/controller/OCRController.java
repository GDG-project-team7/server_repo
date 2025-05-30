package com.example.hipple.controller;

import com.example.hipple.domain.OcrResult;
import com.example.hipple.dto.OcrResultResponse;
import com.example.hipple.repository.OcrResultRepository;
import com.example.hipple.service.OCRService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ocr")
public class OCRController {

    private final OCRService ocrService;
    private final OcrResultRepository ocrResultRepository;

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

    // GET /ocr/{id} ocr 결과 조회 -> 프론트
    @GetMapping("/{id}")
    public ResponseEntity<OcrResultResponse> getOcrResult(@PathVariable Long id) {
        OcrResultResponse response = ocrService.getOcrResultById(id);
        return response != null
                ? ResponseEntity.ok(response)
                : ResponseEntity.notFound().build();
    }

    // 서버에 이미지 저장 (프론트 -> 서버)
    //1. ocr 연동시 postman으로 값 넣기
    //build/libs에 저장됨.
    @PostMapping("/image/save")
    public ResponseEntity<String> saveImage(@RequestParam("file") MultipartFile file) {
        try {
            String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();

            // uploads 디렉토리를 EC2 내 고정 경로로 변경
            String uploadDir = "/home/ubuntu/uploads";
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


    //확인 필요
    @PostMapping("/result")
    public ResponseEntity<String> receiveOcrResult(@RequestBody Map<String, String> body) {
        String imageId = body.get("image_id");
        String ocrResult = body.get("ocr_result");

        System.out.println("AI로부터 받은 이미지 ID: " + imageId);
        System.out.println("AI로부터 받은 OCR 결과: " + ocrResult);

        // 예시로 DB 저장도 가능
        OcrResult saved = ocrResultRepository.save(OcrResult.builder()
                                                           .filename(imageId)
                                                           .extractedText(ocrResult)
                                                           .createdAt(LocalDateTime.now())
                                                           .build());

        return ResponseEntity.ok("AI 결과 수신 및 저장 완료 (id: " + saved.getId() + ")");
    }

    //ai -> 서버
    @GetMapping("/image/{filename}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
        try {
            Path filePath = Paths.get("/home/ubuntu/uploads", filename);
            Resource resource = new UrlResource(filePath.toUri());

            if (!resource.exists() || !resource.isReadable()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}