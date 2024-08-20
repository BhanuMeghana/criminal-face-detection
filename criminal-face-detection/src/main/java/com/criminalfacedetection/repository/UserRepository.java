package com.criminalfacedetection.repository;

import com.criminalfacedetection.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
