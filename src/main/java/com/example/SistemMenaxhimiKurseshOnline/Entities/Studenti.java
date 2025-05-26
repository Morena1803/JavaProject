package com.example.SistemMenaxhimiKurseshOnline.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Studenti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String emri;

    @NotBlank
    private String mbiemri;

    @Email
    @NotBlank
    private String emaili;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
<<<<<<< HEAD
    @JsonIgnore // Per te shmangur ciklet JSON
    private Set<Rregjistrimi> rregjistrimet = new HashSet<>();

    public Studenti() {
    }

    public Studenti(String emri, String mbiemri, String emaili) {
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.emaili = emaili;
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

    public Set<Rregjistrimi> getRregjistrimet() {
        return rregjistrimet;
    }

    public void setRregjistrimet(Set<Rregjistrimi> rregjistrimet) {
        this.rregjistrimet = rregjistrimet;
    }
=======
    @JsonManagedReference
    private Set<Rregjistrimi> rregjistrimet = new HashSet<>();

>>>>>>> 1b241ad (Shtova te gjithe punen e mbetur)
}
