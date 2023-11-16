package com.example.demo.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 *
 * step 1.
 * main controller
 * "/" 기본 루트로 들어오면
 * /question/list 루트로 redirect(question/list라는 루트를 가지고 있는 컨트롤러로)
 *
 *
 * **/
@Controller
public class MainController {

   /**
    * controller과 RestController과의 차이는
    * controller은 응답 객체를 리턴 해주어야 한다. (ResponseBody)
    * RestController은 json형태로 값을 리턴해 준다. (위의 어노테이션이 필요 없다.)
    *
    * **/
   @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }


}
