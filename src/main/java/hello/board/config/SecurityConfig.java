package hello.board.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
/**
 *
 * SpringBootWebSecurityConfiguration클래스를 참조함.
 * API만 사용할 것이기 떄문에 CSRF disabled함.
 * 스프링 시큐리티 바뀐 부분 체크 (https://docs.spring.io/spring-security/reference/reactive/exploits/csrf.html)
 *
 * **/

@Bean
SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {

    // 01. 인증에 대한 로직 작성. 빌더로 작성된 {}안에 로직 작성.
    http.authorizeHttpRequests(
            auth ->{
                auth.anyRequest().authenticated();
            });


    //    http.formLogin(withDefaults());   form로그인 사용하지 않을 예정
    // 02. session사용 여부에 대한 config
    http.sessionManagement(
            session->{
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            });

    // 03. httpBasic 기본 사용
    http.httpBasic(withDefaults());
    // 04. api만 사용하기 때문에 csrf 사용 해제
    http.csrf(
            csrf -> {
                csrf.disable();
            });
//
//    http.cors(
//            cors->{
//               cors.disable();
//            });
    return http.build();
    }


    /**
     *
     * CORS 설정
     * global 설정 (모든 컨트롤러(restcontroller 포함)와 모든 resource에 적용.)
     * local 설정 (특정한 메소드나 요청에만 설정 할 수 있음? )>> 공부 필요.
     * **/

    // 05. CORS적용.. localhost:9000에서 들어오는 모든 요청 허용.
    @Bean
    public WebMvcConfigurer corsConfigrer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("*")
                        .allowedOrigins("http://localhost:9000");
            }
        };
    }


}
