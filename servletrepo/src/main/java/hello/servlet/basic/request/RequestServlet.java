package hello.servlet.basic.request;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


/**
 *
 * reqeust의 각종 정보를 조회하기 위한 클래스
 *
 * **/
@WebServlet(name = "header",urlPatterns = "/request-content")
public class RequestServlet extends HttpServlet {


    private Logger log = LoggerFactory.getLogger(getClass());
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("http Method : {} ",request.getMethod());
        log.info("http Protocol : {}", request.getProtocol());

        /**
         * request에 대한 모든 header에 대한 정보조회 가능
         * 클라이언트가 요청 보낸 파라미터를 직접 조회 할 수 있음.
         * **/
        request.getHeaderNames().asIterator().forEachRemaining(HeaderName ->log.info("headerName : {} ",HeaderName));
        request.getParameterNames().asIterator().forEachRemaining(ParameterName ->log.info("parameterName : {} | Value : {} ",ParameterName, request.getParameter(ParameterName)));

        // 화면에 찍어줄 응답 값.
        response.getWriter().write("OK");


    }
}
