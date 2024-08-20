package com.criminalfacedetection.service;

import com.criminalfacedetection.model.Face;
import com.criminalfacedetection.repository.FaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaceDetectionService {

    @Autowired
    private FaceRepository faceRepository;

    public String detectFaces(String imageUrl) {
        // Implement face detection logic using Azure Face API or similar
        // Save face details to the database
        return "Face detection result";
    }

    public List<Face> getAllFaces() {
        return faceRepository.findAll();
    }
}
