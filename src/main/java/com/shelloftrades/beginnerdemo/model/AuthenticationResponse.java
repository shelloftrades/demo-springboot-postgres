package com.shelloftrades.beginnerdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationResponse {
    private String accessJwt;
    private String refreshJwt;
}
