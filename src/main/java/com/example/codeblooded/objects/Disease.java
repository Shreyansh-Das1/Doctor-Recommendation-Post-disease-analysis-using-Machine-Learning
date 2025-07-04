package com.example.codeblooded.objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Disease {
    @Id
    private String name;
    private String Department;
}
