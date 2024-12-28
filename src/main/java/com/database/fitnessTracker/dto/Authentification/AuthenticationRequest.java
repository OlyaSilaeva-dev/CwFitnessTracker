package com.database.fitnessTracker.dto.Authentification;

import com.database.fitnessTracker.entity.Gender;
import com.database.fitnessTracker.entity.Purpose;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationRequest {
    private String login;
    private String password;
    private String email;
    private Double weight;
    private Double height;
    private Gender gender;
    private Purpose purpose;
}
