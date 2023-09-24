package hello.board.controller;


import hello.board.dto.MemberDto;
import hello.board.mapper.MemberMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberMapper mapper;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/userId")
    public String selectUserId(@RequestParam String userId){

        log.info("UserId : {}", userId);
        String result = mapper.selectUserId(userId);
        return result;
    }


    @PostMapping
    public ResponseEntity<Integer> insert(@RequestBody MemberDto dto){
        log.info("dto : {}",dto);

        int result = mapper.insertMember(dto);
        log.info("insert 성공 했니? ={}",result);
        return ResponseEntity.ok(result);
    }


}
