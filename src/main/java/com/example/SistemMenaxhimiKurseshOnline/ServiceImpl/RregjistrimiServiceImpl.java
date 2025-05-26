package com.example.SistemMenaxhimiKurseshOnline.ServiceImpl;

import com.example.SistemMenaxhimiKurseshOnline.Entities.Kursi;
import com.example.SistemMenaxhimiKurseshOnline.Entities.Rregjistrimi;
import com.example.SistemMenaxhimiKurseshOnline.Entities.Studenti;
import com.example.SistemMenaxhimiKurseshOnline.Repository.KursiRepository;
import com.example.SistemMenaxhimiKurseshOnline.Repository.RregjistrimiRepository;
import com.example.SistemMenaxhimiKurseshOnline.Repository.StudentRepository;
import com.example.SistemMenaxhimiKurseshOnline.Service.RregjistrimiService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RregjistrimiServiceImpl implements RregjistrimiService {

    private final RregjistrimiRepository rregjistrimiRepository;
    private final StudentRepository studentRepository;
    private final KursiRepository kursiRepository;

    public RregjistrimiServiceImpl(
            RregjistrimiRepository rregjistrimiRepository,
            StudentRepository studentRepository,
            KursiRepository kursiRepository) {
        this.rregjistrimiRepository = rregjistrimiRepository;
        this.studentRepository = studentRepository;
        this.kursiRepository = kursiRepository;
    }

    @Override
    public Rregjistrimi krijoRregjistrim(Rregjistrimi rregjistrimi) {
        Long studentId = rregjistrimi.getStudent().getId();
        Studenti studenti = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Studenti me ID " + studentId + " nuk u gjet"));

        Long kursId = rregjistrimi.getKursi().getId();
        Kursi kursi = kursiRepository.findById(kursId)
                .orElseThrow(() -> new RuntimeException("Kursi me ID " + kursId + " nuk u gjet"));

        rregjistrimi.setStudent(studenti);
        rregjistrimi.setKursi(kursi);

        return rregjistrimiRepository.save(rregjistrimi);
    }

    @Override
    public List<Rregjistrimi> gjejTeGjitha() {
        return rregjistrimiRepository.findAll();
    }

    @Override
    public Optional<Rregjistrimi> gjejMeId(Long id) {
        return rregjistrimiRepository.findById(id);
    }

    @Override
    public void fshiRregjistrim(Long id) {
        rregjistrimiRepository.deleteById(id);
    }
}
