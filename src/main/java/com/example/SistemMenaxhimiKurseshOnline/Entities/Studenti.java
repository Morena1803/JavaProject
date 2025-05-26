package com.example.SistemMenaxhimiKurseshOnline.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Studenti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String emri;
    private String mbiemri;
    private String emaili;

    // Lidhja me regjistrimet e kurseve
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // Për të shmangur ciklet JSON në përgjigje
    private Set<Rregjistrimi> rregjistrimet = new HashSet<>();

    // Konstruktori bosh
    public Studenti() {
    }

    // Konstruktori pa regjistrimet (kur krijon një student të ri)
    public Studenti(String emri, String mbiemri, String emaili) {
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.emaili = emaili;
    }

    // Getter/Setter
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

    public Set<Rregjistrimi> getRregjistrimet() {
        return rregjistrimet;
    }

    public void setRregjistrimet(Set<Rregjistrimi> rregjistrimet) {
        this.rregjistrimet = rregjistrimet;
    }
}
