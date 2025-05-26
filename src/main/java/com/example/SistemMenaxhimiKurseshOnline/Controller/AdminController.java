package com.example.SistemMenaxhimiKurseshOnline.Controller;
import com.example.SistemMenaxhimiKurseshOnline.Service.KursiService;
import com.example.SistemMenaxhimiKurseshOnline.Service.StudentService;
import com.example.SistemMenaxhimiKurseshOnline.Service.InstructorService;
import com.example.SistemMenaxhimiKurseshOnline.Entities.Kursi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final KursiService kursiService;
    private final StudentService studentService;
    private final InstructorService instructorService;

    public AdminController(KursiService kursiService,
                           StudentService studentService,
                           InstructorService instructorService) {
        this.kursiService = kursiService;
        this.studentService = studentService;
        this.instructorService = instructorService;
    }

    @GetMapping("/kurset")
    public List<Kursi> printoKurset() {

        return kursiService.gjejTeGjithaKurset();
    }

    @PutMapping("/kurset/{id}")
    public ResponseEntity<Kursi> perditesoKurs(@PathVariable Long id, @RequestBody Kursi kursi) {
        return kursiService.gjejKursMeId(id)
                .map(existing -> {
                    existing.setLlojiKursit(kursi.getLlojiKursit());
                    existing.setPershkrimi(kursi.getPershkrimi());
                    existing.setInstructor(kursi.getInstructor());
                    kursiService.ruajKurs(existing);
                    return ResponseEntity.ok(existing);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/student")
    public ResponseEntity<?> printoStudentet() {
        return ResponseEntity.ok(studentService.printoStudentet());
    }

    // Merr të gjithë instruktorët
    @GetMapping("/instructor")
    public ResponseEntity<?> printoInstruktoret() {
        return ResponseEntity.ok(instructorService.printoInstructoret());
    }


    @DeleteMapping("/student/{id}")
    public ResponseEntity<Void> fshiStudent(@PathVariable Long id) {
        studentService.fshiStudent(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/instructor/{id}")
    public ResponseEntity<Void> fshiInstructor(@PathVariable Long id) {
        instructorService.fshiInstruktor(id);
        return ResponseEntity.noContent().build();
    }
}
