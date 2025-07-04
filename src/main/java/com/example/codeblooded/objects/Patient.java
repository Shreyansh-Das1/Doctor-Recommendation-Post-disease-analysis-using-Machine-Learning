package com.example.codeblooded.objects;

import jakarta.persistence.*;
import lombok.Getter;
@Entity
@Getter
@Table(name="Patient")
public class Patient {
    @Column(name="Name")
    String name;

    @Column(name="Contact Number")
    String phnumber;

    public Patient() {}

    enum Location {
        MALSIPATEL_NAGAR("Malsi"),
        PATEL_NAGAR("Patel Nagar"),
        CLEMENT_TOWN("Clement Town"),
        RAJPUR_ROAD("Rajpur Road"),
        DALANWALA("Dalanwala"),
        JOLLY_GRANT("Jolly Grant"),
        VASANT_VIHAR("Vasant Vihar"),
        HARIDWAR_ROAD("Haridwar Road"),
        KARANPUR("Karanpur"),
        BALLUPUR("Ballupur"),
        BELL_ROAD("Bell Road"),
        GHANTA_GHAR("Ghanta Ghar"),
        KAULAGARH("Kaulagarh"),
        SAHARANPUR_ROAD("Saharanpur Road"),
        RISPANA("Rispana"),
        SWAMI_RAM_NAGAR("Swami Ram Nagar"),
        PREM_NAGAR("Prem Nagar"),
        JAKHAN("Jakhan"),
        RAIPUR("Raipur"),
        PALTAN_BAZAAR("Paltan Bazaar"),
        SUBHASH_NAGAR("Subhash Nagar"),
        NEHRUGRAM("Nehrugram"),
        HATHIBARKALA("Hathibarkala"),
        INDIRA_NAGAR("Indira Nagar"),
        BINDAL_BRIDGE("Bindal Bridge"),
        MUSSOORIE_ROAD("Mussoorie Road"),
        KANWALI("Kanwali"),
        SELAQUI("Selaqui"),
        NEHRU_COLONY("Nehru Colony"),
        DHARAMPUR("Dharampur"),
        RACE_COURSE("Race Course");
        @Column(name="locality")
        private String locality;
        Location(String s) {
            this.locality = s;
        }
    }


    @Column(name="Age")
    private int age;

    @Column(name = "is F")
    private boolean gender;//0 for M and 1 for F

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    public Patient(String name, int age, boolean gender, String phno) {
        this.age = age;
        this.gender = gender;
        this.name = name;
        setPhnumber(phno);
    }

    void setPhnumber(String phno)
    {
        final String PHONE_REGEX = "^(\\+\\d{1,3}[- ]?)?\\(?\\d{3}\\)?[- ]?\\d{3}[- ]?\\d{4}$";
        if(phno.matches(PHONE_REGEX))
            this.phnumber = phno;
        else
            throw new IllegalArgumentException("Invalid phone number");
    }
}
