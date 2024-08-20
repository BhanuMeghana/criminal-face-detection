package com.criminalfacedetection.repository;

import com.criminalfacedetection.model.Face;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaceRepository extends JpaRepository<Face, Long> {
}
