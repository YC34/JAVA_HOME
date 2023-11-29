package com.dev.api.jwt.entity;


import lombok.Getter;

@Getter
public class Subject {

    private final Long accountId;
    private final String email;
    private final String nickname;
    private final String type;


    public Subject(Long accountId, String email, String nickname, String type) {
        this.accountId = accountId;
        this.email = email;
        this.nickname = nickname;
        this.type = type;
    }


    /**
     *
     * 명학하게 명시하여 생성자를 지정.
     * static로 선언한 것은 객체를 생성하지 않고 해당 생성자에 대해 바로 접근 가능하다.
     *
     * **/

    /**
     * access token
     * **/
    public static Subject atk(Long accountId,String email,String nickname){
        return new Subject(accountId,email,nickname,"ATK");

    }

    /**
     * refresh token
     * **/

    public static Subject rtk(Long accountId,String email,String nickname){
        return new Subject(accountId,email,nickname,"RTK");

    }






}
