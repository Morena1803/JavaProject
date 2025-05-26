package com.example.SistemMenaxhimiKurseshOnline.Repository;
import com.example.SistemMenaxhimiKurseshOnline.Entities.Studenti;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Studenti, Long> {
    Optional<Studenti> findByEmaili(String emaili);

}

