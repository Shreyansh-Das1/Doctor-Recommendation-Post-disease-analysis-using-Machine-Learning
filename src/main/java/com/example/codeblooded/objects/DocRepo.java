package com.example.codeblooded.objects;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocRepo extends JpaRepository<Doctor, String> {
    Doctor findBySpec(String Spec);
    Doctor findByDepartment(String Department);
    Doctor  findByLocation(String Location);
}
