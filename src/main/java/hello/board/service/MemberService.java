package hello.board.service;

import hello.board.dto.MemberDto;
import hello.board.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberMapper testMapper;

    public MemberDto test(MemberDto m1) throws Exception {
        return testMapper.insertMember(m1);
    }
}
