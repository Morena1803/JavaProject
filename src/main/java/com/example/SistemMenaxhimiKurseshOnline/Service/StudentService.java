package com.example.SistemMenaxhimiKurseshOnline.Service;

import com.example.SistemMenaxhimiKurseshOnline.Entities.Studenti;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Studenti> printoStudentet();

    Optional<Studenti> gjejStudentMeId(Long id);

    Studenti ruajStudent(Studenti student);

    void fshiStudent(Long id);
}
