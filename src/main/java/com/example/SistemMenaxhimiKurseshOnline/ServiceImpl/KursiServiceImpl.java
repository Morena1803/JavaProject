package com.example.SistemMenaxhimiKurseshOnline.ServiceImpl;

import com.example.SistemMenaxhimiKurseshOnline.Entities.Kursi;
import com.example.SistemMenaxhimiKurseshOnline.Repository.KursiRepository;
import com.example.SistemMenaxhimiKurseshOnline.Service.KursiService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KursiServiceImpl implements KursiService {

    private final KursiRepository kursiRepository;

    public KursiServiceImpl(KursiRepository kursiRepository) {
        this.kursiRepository = kursiRepository;
    }

    @Override
    public List<Kursi> gjejTeGjithaKursat() {
        return kursiRepository.findAll();
    }

    @Override
    public Optional<Kursi> gjejKursMeId(Long id) {
        return kursiRepository.findById(id);
    }

    @Override
    public Kursi ruajKurs(Kursi kursi) {
        return kursiRepository.save(kursi);
    }

    @Override
    public void fshiKurs(Long id) {
        kursiRepository.deleteById(id);
    }
}
