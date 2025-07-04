package com.example.codeblooded.objects;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Doctor {
    private String name;

    enum Spec {
        ONCOLOGY,
        PLASTIC_SURGERY,
        RHEUMATOLOGY,
        NEUROSURGERY,
        PATHOLOGY,
        GENERAL_SURGERY,
        MICROBIOLOGY,
        HEPATOLOGY,
        HEMATOLOGY,
        VASCULAR_SURGERY,
        INFECTIOUS_DISEASE,
        INTERVENTIONAL_CARDIOLOGY,
        NEONATOLOGY,
        CRITICAL_CARE,
        REHABILITATION_MEDICINE,
        THORACIC_SURGERY,
        REPRODUCTIVE_MEDICINE,
        PEDIATRIC_SURGERY,
        GERIATRICS,
        SPORTS_MEDICINE,
        NUCLEAR_MEDICINE,
        CARDIAC_SURGERY,
        PEDIATRIC_ONCOLOGY,
        TRAUMA_SURGERY,
        PALLIATIVE_CARE,
        ADDICTION_MEDICINE,
        PEDIATRIC_CARDIOLOGY,
        INTERVENTIONAL_RADIOLOGY,
        MATERNAL_FETAL_MEDICINE,
        PAIN_MANAGEMENT,
        CLINICAL_PHARMACOLOGY,
        BURN_SURGERY,
        TRANSFUSION_MEDICINE;

        @Column(name = "Specialty")
        private String spec;

        void Spec(String spec) {
            this.spec = spec;
        }
    }
    @Id @Column(unique = true, nullable = false, name="Ph Number")
    String phno;
    @Column(name="Highest Qualification")
    String qualification;
}

