package com.example.SistemMenaxhimiKurseshOnline.Instructor;

import com.example.SistemMenaxhimiKurseshOnline.Kursi.Kursi;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String emri;
    private String mbiemri;
    private String emaili;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Kursi> kursi = new HashSet<>();

    public Instructor() {
    }

    public Instructor(String name, String lastName, String email) {
        this.emri = name;
        this.mbiemri = lastName;
        this.emaili = email;
    }

    public Long getId() {
        return id;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public String getEmaili() {
        return emaili;
    }

    public void setEmaili(String emaili) {
        this.emaili = emaili;
    }

}

