package com.example.demo.user.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



/**
 *
 * postgresql에서는 user라는 테이블명이 예약어이므로 사용을 자제해야한다.
 * **/
@Getter
@Setter
@Entity
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @Column(unique = true)
    private String email;



}
