package com.example.SistemMenaxhimiKurseshOnline.Kursi;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KursiService {

    private final KursiRepository kursiRepository;

    public KursiService(KursiRepository kursiRepository) {
        this.kursiRepository = kursiRepository;
    }

    public List<Kursi> gjejTeGjithaKursat() {
        return kursiRepository.findAll();
    }

    public Optional<Kursi> gjejKursMeId(Long id) {
        return kursiRepository.findById(id);
    }

    public Kursi ruajKurs(Kursi kursi) {
        return kursiRepository.save(kursi);
    }

    public void fshiKurs(Long id) {
        kursiRepository.deleteById(id);
    }
}
