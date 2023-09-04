package hello.board;

import hello.board.dto.MemberDto;

import hello.board.mapper.MemberMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BoardApplicationTests {


    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     *  test code 작성.
     * **/
//
    @Autowired
    private MemberMapper memberMapper;
    @Test
    public void testInsert(){
        MemberDto m1 = new MemberDto();
        m1.setId("chany");
        m1.setName("박영찬");
        m1.setPhone("010-2999-2452");
        log.info("m1 ={}",m1);

       memberMapper.insertMember(m1);



    }

}
