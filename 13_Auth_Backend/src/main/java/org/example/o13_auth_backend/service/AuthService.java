package org.example.o13_auth_backend.service;

import lombok.RequiredArgsConstructor;
import org.example.o13_auth_backend.dto.AuthDTO;
import org.example.o13_auth_backend.dto.AuthResponseDTO;
import org.example.o13_auth_backend.dto.RegisterDTO;
import org.example.o13_auth_backend.entity.Role;
import org.example.o13_auth_backend.entity.User;
import org.example.o13_auth_backend.repository.UserRepository;
import org.example.o13_auth_backend.util.JwtUtil;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthResponseDTO authenticate(AuthDTO authDTO){
        User user=userRepository.findByUsername(authDTO.getUsername())
                .orElseThrow(()->new RuntimeException("User not found"));

        if (!passwordEncoder.matches(
                authDTO.getPassword(),
                user.getPassword())){
            throw new BadCredentialsException("Invalid credentials");
        }

        String token=jwtUtil.generateToken(authDTO.getUsername());
        return new AuthResponseDTO(token, user.getUsername() , user.getRole().name());
    }

    public String register(RegisterDTO registerDTO){
        if (userRepository.findByUsername(registerDTO.getUsername())
                .isPresent()){
            throw new RuntimeException("Username already exists");
        }
        User user=User.builder()
                .username(registerDTO.getUsername())
                .password(passwordEncoder.encode(registerDTO.getPassword()))
                .role(Role.valueOf(registerDTO.getRole()))
                .build();
        userRepository.save(user);
        return "User registered successfully";
    }
}
