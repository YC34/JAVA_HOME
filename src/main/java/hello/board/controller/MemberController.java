package hello.board.controller;


import hello.board.dto.MemberDto;
import hello.board.mapper.MemberMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberMapper mapper;

    private final Logger log = LoggerFactory.getLogger(getClass());
    @PostMapping
    public int insert(){
        MemberDto m1 = new MemberDto();
        m1.setName("tt");
        m1.setId("chtty");
        m1.setPhone("010-2999-2452");

        int result = mapper.insertMember(m1);
        log.info("insert 성공 했니? ={}",result);
        return result;
    }


}
