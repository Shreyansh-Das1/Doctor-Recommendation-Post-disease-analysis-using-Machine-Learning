package com.example.codeblooded.objects.repositories;

import com.example.codeblooded.objects.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {
    Patient findByPhnumber(String phnumber);
    Boolean existsByPhnumber(String phnumber);
}
