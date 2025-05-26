package com.example.SistemMenaxhimiKurseshOnline.Entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Rregjistrimi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @JsonBackReference
    private Studenti student;


    @ManyToOne
    @JoinColumn(name = "kursi_id", nullable = false)
    private Kursi kursi;

    private LocalDate dataRregjistrimit;

    private String status; //aktiv, anuluar ose perfunduar

    public Rregjistrimi() {
    }

    public Rregjistrimi(Studenti student, Kursi kursi, LocalDate dataRregjistrimit, String status) {
        this.student = student;
        this.kursi = kursi;
        this.dataRregjistrimit = dataRregjistrimit;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Studenti getStudent() {

        return student;
    }

    public void setStudent(Studenti student) {

        this.student = student;
    }

    public Kursi getKursi() {
        return kursi;
    }

    public void setKursi(Kursi kursi) {

        this.kursi = kursi;
    }

    public LocalDate getDataRregjistrimit() {

        return dataRregjistrimit;
    }

    public void setDataRregjistrimit(LocalDate dataRregjistrimit) {

        this.dataRregjistrimit = dataRregjistrimit;
    }

    public String getStatus() {

        return status;
    }

    public void setStatus(String status) {

        this.status = status;
    }
}
