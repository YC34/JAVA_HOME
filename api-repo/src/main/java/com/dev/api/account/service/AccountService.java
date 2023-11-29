package com.dev.api.account.service;


import com.dev.api.account.dto.request.LoginRequest;
import com.dev.api.account.dto.request.SignUpRequest;
import com.dev.api.account.dto.response.AccountResponse;
import com.dev.api.account.entity.Account;
import com.dev.api.account.exception.BadRequestException;
import com.dev.api.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor // final로 선언된 객체의 생성자를 자동으로 생성.
public class AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;




    /**
     * 회원가입
     * @param signUpRequest 요청 객체(dto)
     * @return AccountResponse 응답 객체(dto)
     * **/

    @Transactional
    public AccountResponse signUp(SignUpRequest signUpRequest){
        boolean isExist = accountRepository
                .existsByEmail(signUpRequest.getEmail());
        if (isExist) throw new BadRequestException("이미 존재하는 이메일입니다.");
        String encodedPassword = passwordEncoder.encode(signUpRequest.getPassword());

        Account account = new Account(
                signUpRequest.getEmail(),
                encodedPassword,
                signUpRequest.getNickname());

        account = accountRepository.save(account);
        return AccountResponse.of(account);
    }

    /**
     *
     * 로그인
     * @param loginRequest
     * @return AccountReponse
     *
     * **/

    public AccountResponse login(LoginRequest loginRequest){
       Account account = accountRepository
               .findByEmail(loginRequest.getEmail())
               .orElseThrow(()-> new BadRequestException("아이디(이메일)을 확인해 주세요."));

       boolean matches = passwordEncoder.matches(
               loginRequest.getPassword(),
               account.getPassword()
       );
       if(!matches) throw new BadRequestException("비밀번호를 확인하세요.");
       return AccountResponse.of(account);
    }



}
