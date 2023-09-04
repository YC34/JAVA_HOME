package hello.board.mapper;
import hello.board.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;


/**
 * @Mapper은 SpringBoot에서 자동으로 bean으로 등록해주는 어노테이션이 아니므로,
 * 메인 메소드에 MapperScan 어노테이션을 통해, Mapper를 빈으로 등록하여야한다.
 * **/
@Mapper
public interface MemberMapper {
   int insertMember(MemberDto memberDto);


}
