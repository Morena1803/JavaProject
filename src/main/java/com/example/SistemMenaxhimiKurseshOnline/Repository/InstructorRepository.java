package com.example.SistemMenaxhimiKurseshOnline.Repository;
import com.example.SistemMenaxhimiKurseshOnline.Entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InstructorRepository extends JpaRepository<Instructor, Long> {
        Instructor findByEmaili(String email);
}
