package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface MyHandlerAdapter {

    /**
     *
     * @param handler
     * @return boolean true or false
     * @description 객체의 타입이 handler type이면 true를 반환. 이렇게 만든 이유는 확장성..? 다형성? ?
     */
    boolean supports(Object handler);


    /**
     *
     * @param request
     * @param response
     * @param handler
     * @return ModelView객체
     * @throws ServletException
     * @throws IOException
     *
     */
    ModelView handle(HttpServletRequest request, HttpServletResponse response,Object handler) throws ServletException, IOException;
}
