package com.example.SistemMenaxhimiKurseshOnline.Studenti;
import com.example.SistemMenaxhimiKurseshOnline.Kursi.Kursi;
import com.example.SistemMenaxhimiKurseshOnline.Kursi.KursiRepository;
import com.example.SistemMenaxhimiKurseshOnline.Studenti.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class StudentService {


    private final KursiRepository kursiRepository;
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository, KursiRepository kursiRepository) {
        this.studentRepository = studentRepository;
        this.kursiRepository = kursiRepository;
    }


    public List<Studenti> printoStudentet() {
        return studentRepository.findAll();
    }



    public Optional<Studenti> gjejStudentMeId(Long id) {
        return studentRepository.findById(id);
    }


    public Studenti ruajStudent(Studenti student) {
        if (student.getKursi() != null && student.getKursi().getId() != null) {
            Optional<Kursi> kursiOptional = kursiRepository.findById(student.getKursi().getId());

            if (kursiOptional.isPresent()) {
                student.setKursi(kursiOptional.get());
            } else {
                throw new IllegalArgumentException("Kursi me Id " + student.getKursi().getId() + " nuk ekziston");
            }
        } else {
            throw new IllegalArgumentException("Nuk ka asnje kurs te vlefshem per studentin");
        }

        return studentRepository.save(student);
    }



    public void fshiStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
