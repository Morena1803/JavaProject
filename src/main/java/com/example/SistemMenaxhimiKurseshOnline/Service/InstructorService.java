package com.example.SistemMenaxhimiKurseshOnline.Service;

import com.example.SistemMenaxhimiKurseshOnline.Entities.Instructor;

import java.util.List;
import java.util.Optional;

public interface InstructorService {

    List<Instructor> printoInstructorët();

    Optional<Instructor> gjejInstructorMeId(Long id);

    Instructor ruajInstructor(Instructor instructor);

    void fshiInstruktor(Long id);
}
