package com.dev.api.account.exception;

import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException {


    // RuntimeException에 있는 메소드를 상속받아 재사용한다.
    public BadRequestException(String message) {
        super(message);
    }
}
