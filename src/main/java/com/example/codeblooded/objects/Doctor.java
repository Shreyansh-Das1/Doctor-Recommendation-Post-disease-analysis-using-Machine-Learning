package com.example.codeblooded.objects;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Doctor {
    private String name;

    @Column(name = "Specialty") private String spec;
    @Id @Column(unique = true, nullable = false, name="Ph Number") private String phno;
    @Column(name="Hospital") String hospital;
    @Column(name="Highest Qualification") private String qualification;
    @Column(name="Rating") private float rating;
    @Column(name="Department") private String department;
    @Column(name="locality") private String locality;
}



