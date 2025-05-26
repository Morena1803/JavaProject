package com.example.SistemMenaxhimiKurseshOnline.Controller;
import com.example.SistemMenaxhimiKurseshOnline.Entities.Kursi;
import com.example.SistemMenaxhimiKurseshOnline.Entities.Rregjistrimi;
import com.example.SistemMenaxhimiKurseshOnline.Entities.Studenti;
import com.example.SistemMenaxhimiKurseshOnline.Service.KursiService;
import com.example.SistemMenaxhimiKurseshOnline.Service.RregjistrimiService;
import com.example.SistemMenaxhimiKurseshOnline.Service.StudentService;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;
    private final KursiService kursiService;
    private final RregjistrimiService rregjistrimiService;

    public StudentController(StudentService studentService,
                             KursiService kursiService,
                             RregjistrimiService rregjistrimiService) {
        this.studentService = studentService;
        this.kursiService = kursiService;
        this.rregjistrimiService = rregjistrimiService;
    }

    @GetMapping("/kurset")
    public ResponseEntity<List<Kursi>> printoTeGjithaKurset() {
        List<Kursi> kurset = kursiService.gjejTeGjithaKurset();
        return ResponseEntity.ok(kurset);
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
    public ResponseEntity<Studenti> krijoStudent(@RequestBody @Valid Studenti student) {
        Studenti studentiIRuajtur = studentService.ruajStudent(student);
        return ResponseEntity.ok(studentiIRuajtur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Studenti> perditesoStudent(@PathVariable Long id, @RequestBody @Valid Studenti student) {
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


    @PostMapping("/rregjistrohu")
    public ResponseEntity<?> regjistrohuNeKurs(
            @RequestParam Long kursId,
            @AuthenticationPrincipal UserDetails userDetails) {
        // Marrim emailin e studentit nga useri i loguar (AppUser.username = Studenti.emaili)
        String email = userDetails.getUsername();

        Studenti studenti = studentService.gjejStudentSipasEmail(email);
        if (studenti == null) {
            return ResponseEntity.badRequest().body("Studenti nuk u gjet");
        }

        Kursi kursi = kursiService.gjejKursMeId(kursId).orElse(null);
        if (kursi == null) {
            return ResponseEntity.badRequest().body("Kursi nuk ekziston");
        }

        if (rregjistrimiService.ekzistonRregjistrimi(studenti.getId(), kursId)) {
            return ResponseEntity.badRequest().body("Je tashme i regjistruar ne kete kurs");
        }

        Rregjistrimi r = new Rregjistrimi();
        r.setKursi(kursi);
        r.setStudent(studenti);
        r.setDataRregjistrimit(LocalDate.now());
        r.setStatus("AKTIV");

        rregjistrimiService.krijoRregjistrim(r);

        return ResponseEntity.ok("U regjistrove me sukses ne kursin: " + kursi.getLlojiKursit());
    }

    @GetMapping("/kurset-e-mia")
    public ResponseEntity<List<Kursi>> kursetEStudentit(@AuthenticationPrincipal UserDetails userDetails) {
        String email = userDetails.getUsername();
        Studenti studenti = studentService.gjejStudentSipasEmail(email);
        if (studenti == null) return ResponseEntity.badRequest().build();

        List<Kursi> kurset = rregjistrimiService.gjejKursetPerStudent(studenti.getId());
        return ResponseEntity.ok(kurset);
    }

}
