package hello.servlet.basic.request;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "RequestBodyServlet",urlPatterns = "/request-body")
@Slf4j
public class RequestBodyServlet extends HttpServlet {
    /**
     *
     * html form 데이터도 메시지 바디를 통해 전송되므로 직접 읽을 수 있음.
     * 하지만, request.getParameter()을 이미 제공 하므로, 파라미터명으로 조회가능.
     * **/

    //객체로 변환하기 위한 클래스
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


      // byte형태로 받아올수 있음.
      ServletInputStream inputStream = request.getInputStream();
      // byte형태의 데이터를 String 형태로 변환.
      String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

      // 문자열 형태로 받아 온다.
      log.info("messageBody : {} ", messageBody);
      response.getWriter().write("OK");

      // 생성한 객체로 변환하여 출력하기.
      HelloData helloData =objectMapper.readValue(messageBody, HelloData.class);
      log.info("객체로 변환한 데이터(이름) : {} " ,helloData.getName()) ;
      log.info("객체로 변환한 데이터(나이) : {} " ,helloData.getAge()) ;





    }
}
