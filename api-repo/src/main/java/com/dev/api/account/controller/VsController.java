package com.dev.api.account.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @Controller과 @RestController의 비교를 위한 컨트롤러
 *
 * **/



@Controller
@RequestMapping("/json")
public class VsController {

    @GetMapping("/controller")
    @ResponseBody
    public ResponseEntity<ResponseExample> test(){
        ResponseExample responseExample = new ResponseExample("hello test");

        return new ResponseEntity<>(responseExample,HttpStatus.OK);
    }

    /**
     *
     * 테스트용 임시 response객체
     *
     *  **/

    public static class ResponseExample{
        private String message;

        public ResponseExample(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
