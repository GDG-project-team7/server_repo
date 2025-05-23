package com.example.hipple.service;

import net.sourceforge.tess4j.Tesseract;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class OCRService {

    public String extractTextFromImage(MultipartFile file) throws Exception {
        // 1. MultipartFile → File 변환
        File tempFile = convertToFile(file);

        // 2. Tesseract OCR 설정
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("/usr/share/tessdata"); // Linux에 설치된 경로
        tesseract.setLanguage("kor+eng");

        // 3. OCR 실행
        String result = tesseract.doOCR(tempFile);

        // 4. 임시 파일 삭제
        tempFile.delete();

        return result;
    }

    private File convertToFile(MultipartFile file) throws IOException {
        File convFile = File.createTempFile("upload", ".jpg");
        file.transferTo(convFile);
        return convFile;
    }
}