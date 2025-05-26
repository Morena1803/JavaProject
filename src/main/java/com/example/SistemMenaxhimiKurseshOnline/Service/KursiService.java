package com.example.SistemMenaxhimiKurseshOnline.Service;

import com.example.SistemMenaxhimiKurseshOnline.Entities.Kursi;

import java.util.List;
import java.util.Optional;

public interface KursiService {

    List<Kursi> gjejTeGjithaKursat();

    Optional<Kursi> gjejKursMeId(Long id);

    Kursi ruajKurs(Kursi kursi);

    void fshiKurs(Long id);
}
