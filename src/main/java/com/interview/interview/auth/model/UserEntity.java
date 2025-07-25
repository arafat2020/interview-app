package com.interview.interview.auth.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name = "user";

    private String phone;

    private String email;

    private String password;

    private String confirmPassword;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    private Boolean aggriedToTerms = false;

    private Boolean allowPasswordChange = false;

    private String sentOTP;

    private Boolean OTPverified = false;

    private Boolean isDeleted = false;

    private Boolean isBlocked = false;

    private Boolean isLoggedIn = false;

    private LocalDateTime loggedOutTime;

    private LocalDateTime passwordChangeTime;

}
