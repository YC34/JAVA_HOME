package com.dev.api.account.controller;

import com.dev.api.account.dto.request.LoginRequest;
import com.dev.api.account.dto.request.SignUpRequest;
import com.dev.api.account.dto.response.AccountResponse;
import com.dev.api.account.service.AccountService;
import com.dev.api.config.JwtProvider;
import com.dev.api.jwt.dto.reponse.TokenResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    private Logger log = LoggerFactory.getLogger(getClass());

    private final AccountService accountService;
    //restful하게 하기위해 어노테이션으로 구분하여주었다.
    // POST : create, GET : read , PUT: update, DELETE: delete..? 등등

    private final JwtProvider jwtProvider;


    @PostMapping("/sign-up")
    public AccountResponse signUp(@RequestBody SignUpRequest signUpRequest){
                log.info("request : {} ",signUpRequest);
               return accountService.signUp(signUpRequest);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest loginRequest) throws JsonProcessingException {

        AccountResponse accountResponse = accountService.login(loginRequest);
        return jwtProvider.createTokensByLogin(accountResponse);

    }

}
