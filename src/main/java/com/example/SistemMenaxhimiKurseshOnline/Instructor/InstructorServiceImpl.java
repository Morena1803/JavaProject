package com.example.SistemMenaxhimiKurseshOnline.Instructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> printoInstructorët() {
        return instructorRepository.findAll();
    }

    @Override
    public Optional<Instructor> gjejInstructorMeId(Long id) {
        return instructorRepository.findById(id);
    }

    @Override
    public Instructor ruajInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public void fshiInstruktor(Long id) {
        instructorRepository.deleteById(id);
    }
}
