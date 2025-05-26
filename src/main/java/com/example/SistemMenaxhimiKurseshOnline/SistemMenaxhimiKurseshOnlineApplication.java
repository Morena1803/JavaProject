package com.example.SistemMenaxhimiKurseshOnline;
import com.example.SistemMenaxhimiKurseshOnline.Entities.AppUser;
import com.example.SistemMenaxhimiKurseshOnline.Entities.AppUser.Role;
import com.example.SistemMenaxhimiKurseshOnline.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SistemMenaxhimiKurseshOnlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemMenaxhimiKurseshOnlineApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			String username = "admin";

			if (userRepository.findByUsername(username).isEmpty()) {
				String encodedPassword = passwordEncoder.encode("admin123");
				AppUser admin = new AppUser(username, encodedPassword, Role.ADMIN);
				userRepository.save(admin);

			}
	};
}}
