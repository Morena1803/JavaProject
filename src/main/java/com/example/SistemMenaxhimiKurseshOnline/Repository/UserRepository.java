package com.example.SistemMenaxhimiKurseshOnline.Repository;
import com.example.SistemMenaxhimiKurseshOnline.Entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
}
