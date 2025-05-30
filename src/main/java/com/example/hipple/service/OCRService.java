package com.example.hipple.service;

import com.example.hipple.domain.OcrResult;
import com.example.hipple.dto.OcrResultResponse;
import com.example.hipple.repository.OcrResultRepository;
import lombok.RequiredArgsConstructor;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OCRService {

    private final OcrResultRepository ocrResultRepository;

    public OcrResultResponse extractTextFromImage(MultipartFile file) throws Exception {
        // 1. 임시 저장
        File tempFile = convertToFile(file);

        // 2. OCR
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("/usr/share/tessdata"); // 리눅스 기준
        tesseract.setLanguage("kor+eng");
        String extractedText = tesseract.doOCR(tempFile);

        // 3. DB 저장
        String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
        OcrResult result = OcrResult.builder()
                .filename(filename)
                .extractedText(extractedText)
                .createdAt(LocalDateTime.now())
                .build();
        OcrResult saved = ocrResultRepository.save(result);

        // 4. 반환 DTO 생성
        tempFile.delete(); // 임시 파일 삭제

        // 결과 반환
        return OcrResultResponse.builder()
                .id(saved.getId())
                .filename(saved.getFilename())
                .extractedText(saved.getExtractedText())
                .createdAt(saved.getCreatedAt())
                .build();
    }

    public OcrResultResponse getOcrResultById(Long id) {
        return ocrResultRepository.findById(id)
                .map(result -> OcrResultResponse.builder()
                        .id(result.getId())
                        .filename(result.getFilename())
                        .extractedText(result.getExtractedText())
                        .createdAt(result.getCreatedAt())
                        .build())
                .orElse(null);
    }

    private File convertToFile(MultipartFile file) throws IOException {
        File convFile = File.createTempFile("upload", ".jpg");
        file.transferTo(convFile);
        return convFile;
    }
}
