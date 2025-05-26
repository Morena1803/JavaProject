package com.example.SistemMenaxhimiKurseshOnline.ServiceImpl;

import com.example.SistemMenaxhimiKurseshOnline.Entities.Studenti;
import com.example.SistemMenaxhimiKurseshOnline.Repository.StudentRepository;
import com.example.SistemMenaxhimiKurseshOnline.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    @Override
    public List<Studenti> printoStudentet() {

        return studentRepository.findAll();
    }

    @Override
    public Studenti gjejStudentSipasEmail(String email) {

        return studentRepository.findByEmaili(email).orElse(null);
    }

    @Override
    public Optional<Studenti> gjejStudentMeId(Long id) {

        return studentRepository.findById(id);
    }

    @Override
    public Studenti ruajStudent(Studenti student) {

        return studentRepository.save(student);
    }

    @Override
    public void fshiStudent(Long id) {

        studentRepository.deleteById(id);
    }
}
