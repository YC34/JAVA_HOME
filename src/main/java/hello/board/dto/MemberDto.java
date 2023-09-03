package hello.board.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {

    // idx DB에서 시퀀스로 이용.
    //name
    private String name;
    private String id;
    private String phone;

}
