package com.example.SistemMenaxhimiKurseshOnline.Controller;
import com.example.SistemMenaxhimiKurseshOnline.Entities.Rregjistrimi;
import com.example.SistemMenaxhimiKurseshOnline.Service.RregjistrimiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rregjistrimi")
public class RregjistrimiController {

    private final RregjistrimiService rregjistrimiService;

    public RregjistrimiController(RregjistrimiService rregjistrimiService) {
        this.rregjistrimiService = rregjistrimiService;
    }

    @GetMapping
    public List<Rregjistrimi> gjejTeGjitha() {

        return rregjistrimiService.gjejTeGjitha();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rregjistrimi> gjejMeId(@PathVariable Long id) {
        return rregjistrimiService.gjejMeId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Rregjistrimi krijo(@RequestBody Rregjistrimi rregjistrimi) {
        return rregjistrimiService.krijoRregjistrim(rregjistrimi);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> fshi(@PathVariable Long id) {
        rregjistrimiService.fshiRregjistrim(id);
        return ResponseEntity.noContent().build();
    }
}
