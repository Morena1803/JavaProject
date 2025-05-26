package com.example.SistemMenaxhimiKurseshOnline.Controller;
import com.example.SistemMenaxhimiKurseshOnline.Entities.AppUser;
import com.example.SistemMenaxhimiKurseshOnline.Entities.AppUser.Role;
import com.example.SistemMenaxhimiKurseshOnline.Repository.UserRepository;
import com.example.SistemMenaxhimiKurseshOnline.Security.JwtTokenProvider;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    // 🔐 Login endpoint
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        AppUser user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Perdoruesi nuk ekziston"));

        String token = tokenProvider.generateToken(user);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    // 📝 Register endpoint
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username ekziston");
        }

        Role role;
        try {
            role = Role.valueOf(request.getRole().toUpperCase());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Roli nuk eshte i vlefshem, përdor: STUDENT, INSTRUCTOR, ADMIN");
        }

        String encodedPassword = passwordEncoder.encode(request.getPassword());

        AppUser user = new AppUser(
                request.getUsername(),
                encodedPassword,
                role
        );

        userRepository.save(user);
        return ResponseEntity.ok("Perdoruesi u regjistrua me sukses si " + role);
    }

    // DTO për login
    public static class LoginRequest {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
    }

    // DTO për përgjigjen me token
    public static class JwtResponse {
        private String token;
        public JwtResponse(String token) {
            this.token = token;
        }
        public String getToken() {
            return token;
        }
    }

    // DTO për regjistrimin me validime
    public static class RegisterRequest {

        @Email(message = "Emaili nuk eshte ne formatin e duhur")
        @NotBlank(message = "Emaili nuk duhet te lihet bosh")
        private String username;

        @NotBlank(message = "Passwordi nuk duhet te lihet bosh")
        private String password;

        @NotBlank(message = "Roli nuk duhet të lihet bosh")
        private String role;

        public String getUsername() {

            return username;
        }
        public void setUsername(String username) {

            this.username = username;
        }

        public String getPassword() {

            return password;
        }
        public void setPassword(String password) {

            this.password = password;
        }

        public String getRole() {

            return role;
        }
        public void setRole(String role) {

            this.role = role;
        }
    }
}
