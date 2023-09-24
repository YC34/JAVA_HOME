package hello.board.controller;


import hello.board.dto.MemberDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class viewController {

    private static final Logger log = LoggerFactory.getLogger(viewController.class);


    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("login-error","로그인이 잘못 되었습니다.");
        return "login";
    }

    @PostMapping("/dashboard")
    public String dashboardPage(@RequestParam("userId") String userId,
                                @RequestParam("password") String password){
        log.info("id : {}",userId);
        log.info("phone : {}",password);


        return " redirect:/view/dashboard";
    }

}

