package hello.board.mapper;


import hello.board.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberMapper {
    void insertMember(MemberDto memberDto);


}
