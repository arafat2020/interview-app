package com.interview.interview.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

@RestController
@Tag(name = "Authentication", description = "Endpoints for user authentication")
public class AuthController {

    @PostMapping("/register")
    @Operation(summary = "Authentication Endpoint", description = "Endpoint for user login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        System.out.println(request.password + request.username);
        return new AuthResponse("fake-token");
    }

    @PostMapping("path")
    @Operation(summary = "Registration Endpoint", description = "Endpoint for user registration")
    public String register(@RequestBody RegisterRequest entity) {

        return entity.toString();
    }

    public static class AuthRequest {
        private String username;
        private String password;

        public AuthRequest() {
        }

        public AuthRequest(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    public static class AuthResponse {
        private String token;

        public AuthResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }
    }

    @Data
    public class RegisterRequest {
        private String name;
        private String phone;
        private String email;
        private String password;
        private String confirmPassword;
        private Boolean aggriedToTerms;
    }
}
