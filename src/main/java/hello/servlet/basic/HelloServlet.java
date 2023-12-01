package hello.servlet.basic;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet(name = "helloServlet",urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("hello servlet");

        /**
         * reqeust에는 모든 요청에 대한 값을 조회 할 수 있다.
         * slf4j의 logging을 사용해도 되지만 , application.properties에서 http에 대한 로깅이 기능하다.
         * **/
        log.info("request : {} ",request.getClass());
        log.info("request : {}", request.getLocalPort());
        log.info("reponse : {}",response.getStatus());


    }
}
