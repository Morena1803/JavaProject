package com.example.SistemMenaxhimiKurseshOnline.Repository;
import com.example.SistemMenaxhimiKurseshOnline.Entities.Rregjistrimi;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RregjistrimiRepository extends JpaRepository<Rregjistrimi, Long> {
    List<Rregjistrimi> findAllByStudentId(Long studentId);

}
