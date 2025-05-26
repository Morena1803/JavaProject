package com.example.SistemMenaxhimiKurseshOnline.Controller;
import com.example.SistemMenaxhimiKurseshOnline.Entities.Instructor;
import com.example.SistemMenaxhimiKurseshOnline.Entities.Kursi;
import com.example.SistemMenaxhimiKurseshOnline.Service.InstructorService;
import com.example.SistemMenaxhimiKurseshOnline.Service.KursiService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/instructor")
public class InstructorController {

    private final InstructorService instructorService;
    private final KursiService kursiService;

    public InstructorController(InstructorService instructorService, KursiService kursiService) {
        this.instructorService = instructorService;
        this.kursiService = kursiService;
    }

    @GetMapping
    public List<Instructor> Instructoret() {
        return instructorService.printoInstructoret();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> gjejInstructorMeId(@PathVariable Long id) {
        return instructorService.gjejInstructorMeId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Instructor krijoInstructor(@RequestBody @Valid Instructor instructor) {
        return instructorService.ruajInstructor(instructor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instructor> perditesoInstructor(@PathVariable Long id,
                                                          @RequestBody @Valid Instructor instructor) {
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

    @GetMapping("/kurset")
    public ResponseEntity<List<Kursi>> kursetInstruktorit(@AuthenticationPrincipal UserDetails userDetails) {
        String email = userDetails.getUsername();
        List<Kursi> kurset = kursiService.gjejKursetESecilitInstruktor(email);
        return ResponseEntity.ok(kurset);
    }

    @PutMapping("/kurset/{id}")
    public ResponseEntity<Kursi> perditesoKursetInstruktorit(@PathVariable Long id,
                                                             @RequestBody Kursi kursi,
                                                             @AuthenticationPrincipal UserDetails userDetails) {

        Kursi ekzistues = kursiService.gjejKursMeId(id).orElse(null);
        if (ekzistues == null) return ResponseEntity.notFound().build();

        if (!ekzistues.getInstructor().getEmaili().equals(userDetails.getUsername())) {
            return ResponseEntity.status(403).build();
        }

        ekzistues.setLlojiKursit(kursi.getLlojiKursit());
        ekzistues.setPershkrimi(kursi.getPershkrimi());

        Kursi iPerditesuar = kursiService.ruajKurs(ekzistues);
        return ResponseEntity.ok(iPerditesuar);
    }

    @PostMapping("/shto-kurs")
    public ResponseEntity<?> shtoKurs(@RequestBody @Valid Kursi kursi,
                                      @AuthenticationPrincipal UserDetails userDetails) {

        String email = userDetails.getUsername();
        Instructor instruktor = instructorService.gjejInstructorSipasEmail(email);
        if (instruktor == null) {
            return ResponseEntity.badRequest().body("Instruktori nuk u gjet.");
        }

        kursi.setInstructor(instruktor);
        Kursi kursiIRuajtur = kursiService.ruajKurs(kursi);

        return ResponseEntity.ok(kursiIRuajtur);
    }
}
