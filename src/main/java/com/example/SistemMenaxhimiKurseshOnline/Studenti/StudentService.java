package com.example.SistemMenaxhimiKurseshOnline.Studenti;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Studenti> printoStudentet();

    Optional<Studenti> gjejStudentMeId(Long id);

    Studenti ruajStudent(Studenti student);

    void fshiStudent(Long id);
}
