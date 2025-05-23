package com.example.SistemMenaxhimiKurseshOnline.Studenti;
import com.example.SistemMenaxhimiKurseshOnline.Kursi.Kursi;
import jakarta.persistence.*;

@Entity
public class Studenti{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String emri;
    private String mbiemri;
    private String emaili;

    @ManyToOne
    @JoinColumn(name = "kursi_id")
    private Kursi kursi;

    public Studenti() {
    }

    public Studenti(String emri, String mbiemri, String emaili, Kursi kursi) {
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.emaili = emaili;
        this.kursi = kursi;
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

    public Kursi getKursi() {
        return kursi;
    }

    public void setKursi(Kursi kursi) {
        this.kursi = kursi;
    }
}
