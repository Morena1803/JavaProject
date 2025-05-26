package com.example.SistemMenaxhimiKurseshOnline.Controller;
import com.example.SistemMenaxhimiKurseshOnline.Entities.Kursi;
import com.example.SistemMenaxhimiKurseshOnline.Service.KursiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kursi")
public class KursiController {

    private final KursiService kursiService;

    public KursiController(KursiService kursiService) {
        this.kursiService = kursiService;
    }

    @GetMapping
    public List<Kursi> gjitheKursat() {
        return kursiService.gjejTeGjithaKursat();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kursi> gjejKursMeId(@PathVariable Long id) {
        return kursiService.gjejKursMeId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Kursi krijoKurs(@RequestBody Kursi kursi) {
        return kursiService.ruajKurs(kursi);
    }

    @PutMapping("/{id}")
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> fshiKurs(@PathVariable Long id) {
        kursiService.fshiKurs(id);
        return ResponseEntity.noContent().build();
    }
}
