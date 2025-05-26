package com.example.SistemMenaxhimiKurseshOnline.Repository;

import com.example.SistemMenaxhimiKurseshOnline.Entities.Kursi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KursiRepository extends JpaRepository<Kursi, Long> {
    List<Kursi> findAllByInstructor_Emaili(String emaili);
}
