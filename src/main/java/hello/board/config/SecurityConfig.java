package hello.board.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
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
    // TODO 05. cors 사용법 숙지하기.
    http.cors(
            cors->{
               cors.disable();
            });
    return http.build();
    }

}
