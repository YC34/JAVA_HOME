package com.dev.api.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
           http
                   .authorizeRequests((authorizeRequests)->      // 인증된 사용자만 접근할수 있도록 설정
                           authorizeRequests
                                   .antMatchers("/account/sign-up", "/account/login","/json/controller","/json/restcontroller").permitAll() // 특정 URI에는 누구나 접근 가능하게 함.
                                   .anyRequest().authenticated())
                .csrf((csrf)->csrf.disable()) //csrf 비활성화.
                .cors((cors)->cors.disable()) ;//cors 비활성화
           return http.build();

    }
}
