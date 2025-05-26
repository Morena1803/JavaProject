package com.example.SistemMenaxhimiKurseshOnline.Repository;
import com.example.SistemMenaxhimiKurseshOnline.Entities.Studenti;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Studenti, Long> {
}

