package com.criminalfacedetection.controller;

import com.criminalfacedetection.model.Face;
import com.criminalfacedetection.service.FaceDetectionService;
import com.criminalfacedetection.service.AzureBlobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/faces")
public class FaceDetectionController {

    @Autowired
    private FaceDetectionService faceDetectionService;

    @Autowired
    private AzureBlobService azureBlobService;

    @PostMapping("/upload")
    public String uploadFace(@RequestParam("file") MultipartFile file) throws IOException {
        String imageUrl = azureBlobService.uploadFile(file);
        return faceDetectionService.detectFaces(imageUrl);
    }

    @GetMapping
    public List<Face> getAllFaces() {
        return faceDetectionService.getAllFaces();
    }
}
