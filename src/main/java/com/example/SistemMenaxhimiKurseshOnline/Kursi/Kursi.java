package com.example.SistemMenaxhimiKurseshOnline.Kursi;
import com.example.SistemMenaxhimiKurseshOnline.Instructor.Instructor;
import jakarta.persistence.*;

@Entity
public class Kursi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String llojiKursit;
    private String pershkrimi;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    public Kursi() {
    }

    public Kursi(String llojiKursit, String pershkrimi, Instructor instructor) {
        this.llojiKursit = llojiKursit;
        this.pershkrimi = pershkrimi;
        this.instructor = instructor;
    }

    public Long getId() {
        return id;
    }

    public String getLlojiKursit() {
        return llojiKursit;
    }

    public void setLlojiKursit(String llojiKursit) {
        this.llojiKursit = llojiKursit;
    }

    public String getPershkrimi() {
        return pershkrimi;
    }

    public void setPershkrimi(String pershkrimi) {
        this.pershkrimi = pershkrimi;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

}
