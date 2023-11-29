package com.dev.api.account.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)  // 기본 생성자에 대해 접근을 막기 위함. 객체를 사용하기 위해 아래 생성자를 명시.
public class Account {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //DB의 기본키 전략. 시퀀스를 명시하지 않았기 때문.
    private Long id;
    private String email;
    private String password;

    private String nickname;

    public Account(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }
}
