package hello.board.config;


import jakarta.servlet.DispatcherType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
/**
 * Spring boot Security !!! 공부하기.
 * 변경된 사항 반영하기.
 *
 * **/

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable().cors().disable()
//                .authorizeHttpRequests(request -> request.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
//                )
//                .formLogin(login->login
//                        .loginPage("/view/login")
//                        .loginProcessingUrl("login-process")
//                        .usernameParameter("userId")
//                        .defaultSuccessUrl("/")
//                        .permitAll()
//                        .failureUrl("/view/login-error")
//                )
//                .logout(Customizer.withDefaults());
//
//        return http.getOrBuild();
//    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(
                auth->{
                    auth.anyRequest().authenticated();
                });

        // session 사용 해제
        http.sessionManagement(
                session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );
//        http.formLogin();

        http.httpBasic();
        http.csrf().disable();
        return http.getOrBuild();
    }


    /**
     *
     * CORS CONFIG
     *
     * **/
//    @Bean
//    public WebMvcConfigurer corsConfigurer(){
//        return new WebMvcConfigurer() {
//            public void addCorsMappings(CorsRegistry registry){
//                registry.addMapping("/**")
//                        .allowedMethods("*")
//                        .allowedOrigins("http://localhost:9000");
//            }
//        }
//    }


//    @Bean
//    public UserDetailsService userDetailsService(){
//        User
//                .withUsername("xxx")
//                .password("")
//        return new InMemoryUserDetailsManager();
//    }

}
