package com.example.CarProject.api;

import com.example.CarProject.dto.AuthRequest;
import com.example.CarProject.dto.AuthResponse;
import com.example.CarProject.dto.RegisterRequest;
import com.example.CarProject.model.User;
import com.example.CarProject.repository.UserRepository;
import com.example.CarProject.securityJwt.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/role")
    public ResponseEntity<String> getRole(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return ResponseEntity.ok("Ваша роль: " + user.getRole());
    }

    @GetMapping("/check")
    public ResponseEntity<String> checkToken() {
        return ResponseEntity.ok("Токен валиден");
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            return ResponseEntity.badRequest().body(new AuthResponse(null, "Ошибка: Пользователь уже существует!"));
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("USER");

        System.out.println("Создаём пользователя: " + user.getUsername() + " с ролью " + user.getRole());

        userRepository.save(user);

        String token = jwtService.generateToken(user);

        return ResponseEntity.ok(new AuthResponse(token, "/login"));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Неверный пароль");
        }

        String token = jwtService.generateToken(user);
        return ResponseEntity.ok(new AuthResponse(token, "/home"));
    }

    @PutMapping("/makeAdmin/{username}")
    public ResponseEntity<String> makeAdmin(@PathVariable String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));

        user.setRole("ADMIN");
        userRepository.save(user);

        return ResponseEntity.ok("Роль пользователя обновлена. Залогиньтесь снова.");
    }
}
