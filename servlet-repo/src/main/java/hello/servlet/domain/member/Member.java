package hello.servlet.domain.member;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {

    // 고유한 id 값 .
    private Long id;
    // 유저 이름
    private String username;
    // 나이
    private int age;

    // 기본 생성자
    public Member() {
    }

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
