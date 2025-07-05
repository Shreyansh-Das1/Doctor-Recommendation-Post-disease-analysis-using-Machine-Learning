package com.example.codeblooded.objects.repositories;

import com.example.codeblooded.objects.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocRepo extends JpaRepository<Doctor, String> {
    @Query(value = "SELECT * FROM DocRepo WHERE department==%:keyword% ORDER BY rating desc LIMIT 5", nativeQuery = true)
    List<Doctor> searchByDepartment(@Param("keyword") String department);

    Doctor findByDepartment(String Department);
    Doctor findByHospital(String Hospital);
}
