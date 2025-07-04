package com.example.codeblooded.objects.repositories;

import com.example.codeblooded.objects.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseRepo extends JpaRepository<Disease, String> {
    Disease findByName(String name);
}
