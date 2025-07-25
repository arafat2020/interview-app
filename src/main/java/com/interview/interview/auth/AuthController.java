package com.interview.interview.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Authentication", description = "Endpoints for user authentication")
public class AuthController {
    @PostMapping("/login")
    @Operation(summary = "Authentication Endpoint", description = "Endpoint for user login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        System.out.println(request.password + request.username);
        return new AuthResponse("fake-token");
    }

     public static class AuthRequest {
        private String username;
        private String password;
        public AuthRequest() {}
        public AuthRequest(String username, String password) {
            this.username = username;
            this.password = password;
        }
        public String getUsername() { return username; }
        public String getPassword() { return password; }
    }

    public static class AuthResponse {
        private String token;
        public AuthResponse(String token) { this.token = token; }
        public String getToken() { return token; }
    }
}
