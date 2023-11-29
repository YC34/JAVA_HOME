package com.dev.api.jwt.dto.reponse;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TokenResponse {
    private String atk;
    private String rtk;

}
