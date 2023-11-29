package com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;




/**
 *
 * spring boot security6.xx 버전부터 config가 변경되었다.
 * build.gradle에 dependency를 추가하고 rebuild를 한번 진행한다.
 *
 *
 * **/


@EnableWebSecurity // 시큐리티 어노테이션
@Configuration // 설정 어노테이션
public class SecurityConfig {



    /**
     *
     * Authentication 인증 : 로그인
     * authorize 권한 : 인증된 사용자가 어떤 것을 할 수 있는지를 의미.
     * csrf 기본적으로 스프링 스큐리티를 적용하면, 활성화 되어있다.
     *
     * **/

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests((authorizeHttpRequests)->      //  모든 경로에 권한을 부여한다.
                        authorizeHttpRequests.requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
                .csrf((csrf)->csrf.disable()) //csrf 비활성화.
                .headers((headers)->headers //  같은 페이지에 대해서만 허용한다.
                        .addHeaderWriter(new XFrameOptionsHeaderWriter(
                                XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
                .formLogin((formLogin)->formLogin // form로그인을 사용한다.
                        .loginPage("/user/login") // login페이지에 대한 URL
                        .defaultSuccessUrl("/")) // 성공에 대한 URL
                .logout((logout)->logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout")) // logout에 대한 URL
                        .logoutSuccessUrl("/") // 성공에 대한 URL
                        .invalidateHttpSession(true)) // logout시 모든 session이 초기화
        ;

        return http.build();
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();

    }




}
