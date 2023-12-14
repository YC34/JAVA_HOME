package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {


    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1(){
        ModelAndView mav = new ModelAndView("hello");
            mav.addObject("data","hello!");

        return  mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV1(Model model){
        String data = "hello";
        model.addAttribute("data",data);


        return  "hello";
    }





}
