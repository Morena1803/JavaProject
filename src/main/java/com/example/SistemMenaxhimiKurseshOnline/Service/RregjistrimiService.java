package com.example.SistemMenaxhimiKurseshOnline.Service;
import com.example.SistemMenaxhimiKurseshOnline.Entities.Rregjistrimi;
import java.util.List;
import java.util.Optional;
public interface RregjistrimiService {

    Rregjistrimi krijoRregjistrim(Rregjistrimi rregjistrimi);

    List<Rregjistrimi> gjejTeGjitha();

    Optional<Rregjistrimi> gjejMeId(Long id);

    void fshiRregjistrim(Long id);
}
