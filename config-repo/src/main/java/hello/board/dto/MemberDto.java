package hello.board.dto;

import lombok.*;

@Getter
@Setter
public class MemberDto {

    // idx DB에서 시퀀스로 이용.

    // 이름
    private String name;
    // 아이디
    private String userId;

    // 유저 폰넘버
    private String phone;

    // 유저 비밀번호.
    private String password;

}
