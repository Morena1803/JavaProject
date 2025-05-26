package com.example.SistemMenaxhimiKurseshOnline.Controller;
import com.example.SistemMenaxhimiKurseshOnline.Entities.Instructor;
import com.example.SistemMenaxhimiKurseshOnline.Service.InstructorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructor")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public List<Instructor> Instructorët() {
        return instructorService.printoInstructorët();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> gjejInstructorMeId(@PathVariable Long id) {
        return instructorService.gjejInstructorMeId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Instructor krijoInstructor(@RequestBody Instructor instructor) {
        return instructorService.ruajInstructor(instructor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instructor> perditesoInstructor(@PathVariable Long id, @RequestBody Instructor instructor) {
        return instructorService.gjejInstructorMeId(id)
                .map(existing -> {
                    existing.setEmri(instructor.getEmri());
                    existing.setMbiemri(instructor.getMbiemri());
                    existing.setEmaili(instructor.getEmaili());
                    instructorService.ruajInstructor(existing);
                    return ResponseEntity.ok(existing);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> fshiInstructor(@PathVariable Long id) {
        instructorService.fshiInstruktor(id);
        return ResponseEntity.noContent().build();
    }
}

