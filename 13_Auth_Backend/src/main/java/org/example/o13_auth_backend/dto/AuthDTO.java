package org.example.o13_auth_backend.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class AuthDTO {
    private String username;
    private String password;
}
