package hello.board.controller;


import hello.board.dto.MemberDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class viewController {

    private static final Logger log = LoggerFactory.getLogger(viewController.class);
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("login-error","로그인이 잘몰 되었습니다.");
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboardPage(MemberDto dto,Model model){
        log.info("id : {}",dto.getId());
        log.info("phone : {}",dto.getPhone());


        model.addAttribute("userId",dto.getId());
        model.addAttribute("phone",dto.getPhone());

        return "dashboard";
    }

}
