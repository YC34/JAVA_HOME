package hello.board.controller;


import hello.board.dto.MemberDto;
import hello.board.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/member")
public class MemberController {

  

    @PostMapping
    public String insert(){
        MemberDto m1 = new MemberDto();
        m1.setName("박영찬");
        m1.setId("chany");
        m1.setPhone("010-2999-2452");
        
        MemberMapper mapper = null;
        mapper.insertMember(m1);
        return "ok";
    }


}
