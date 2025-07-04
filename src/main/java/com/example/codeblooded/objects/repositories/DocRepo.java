package com.example.codeblooded.objects.repositories;

import com.example.codeblooded.objects.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocRepo extends JpaRepository<Doctor, String> {

    Doctor findByDepartment(String Department);
    Doctor  findByLocality(String Location);
    Doctor findByHospital(String Hospital);
}
