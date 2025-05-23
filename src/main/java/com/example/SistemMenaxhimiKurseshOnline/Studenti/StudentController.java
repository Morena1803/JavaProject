package com.example.SistemMenaxhimiKurseshOnline.Studenti;
import org.springframework.http.ResponseEntity;
import com.example.SistemMenaxhimiKurseshOnline.Studenti.StudentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;


@RestController
@RequestMapping("/api/student")
public class StudentController {



    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public List<Studenti> gjitheStudentet() {

        return studentService.printoStudentet();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Studenti> gjejStudentMeId(@PathVariable Long id) {
        return studentService.gjejStudentMeId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Studenti> krijoStudent(@RequestBody Studenti student) {
        Studenti studentiIRuajtur = studentService.ruajStudent(student);
        return ResponseEntity.ok(studentiIRuajtur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Studenti> perditesoStudent(@PathVariable Long id, @RequestBody Studenti student) {
        return studentService.gjejStudentMeId(id)
                .map(existingStudent -> {
                    existingStudent.setEmri(student.getEmri());
                    existingStudent.setMbiemri(student.getMbiemri());
                    existingStudent.setEmaili(student.getEmaili());
                    studentService.ruajStudent(existingStudent);
                    return ResponseEntity.ok(existingStudent);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> fshiStudent(@PathVariable Long id) {
        studentService.fshiStudent(id);
        return ResponseEntity.noContent().build();
    }
}
