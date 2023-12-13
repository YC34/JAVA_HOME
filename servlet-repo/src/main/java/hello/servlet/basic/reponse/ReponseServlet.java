package hello.servlet.basic.reponse;


import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.request.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ReponseServlet",urlPatterns = "/response-servlet")
public class ReponseServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");


        HelloData helloData = new HelloData();
        helloData.setName("용찬");
        helloData.setAge(12);

        String result =objectMapper.writeValueAsString(helloData);

        response.getWriter().write(result);


    }
}
