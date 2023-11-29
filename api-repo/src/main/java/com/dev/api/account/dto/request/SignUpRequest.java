package com.dev.api.account.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;






//TODO json 형태로 요청이 들어오면 기본 생성자를 만들지 못하였음.
// 필드의 final로 만드려면 어떻게 해야하는가..?
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {

    private String email;
    private String password;
    private String nickname;


}
