package org.example.o13_auth_backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.o13_auth_backend.dto.APIResponse;
import org.example.o13_auth_backend.dto.AuthDTO;
import org.example.o13_auth_backend.dto.RegisterDTO;
import org.example.o13_auth_backend.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<APIResponse> registerUser(
            @RequestBody RegisterDTO registerDTO){
        return ResponseEntity.ok(
                new APIResponse(
                        200,
                        "User registered successfully",
                        authService.register(registerDTO)
                )
        );
    }
    @PostMapping("/login")
    public ResponseEntity<APIResponse> login(@RequestBody AuthDTO authDTO){
        return ResponseEntity.ok(new APIResponse(200,
                "OK",authService.authenticate(authDTO)));
    }
}
