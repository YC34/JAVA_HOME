package hello.board.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecuritytestController {

    /**
     *
     * post요청에는 CSRF토큰이 필요하다. update, create 등.
     * 1. csrf는 토큰 생성하여, 동기화 방식.
     * 2. 같은 사이트에 대해서는 samesite cookie를 사용한다.
     *      (set-cookies : SameSite=Strict )
     *      설정 법 application-properties에
     *      server.servlet.session.cookie.same-site=strict
     *
     * **/
    @GetMapping("csrf-token")
    public CsrfToken csrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
