package com.example.SistemMenaxhimiKurseshOnline.Instructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public List<Instructor> printoInstructorët() {
        return instructorRepository.findAll();
    }

    public Optional<Instructor> gjejInstructorMeId(Long id) {
        return instructorRepository.findById(id);
    }

    public Instructor ruajInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public void fshiInstruktor(Long id) {
        instructorRepository.deleteById(id);
    }
}
