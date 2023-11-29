package com.dev.api.account.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/json")
public class VsRestController {




    @GetMapping("/restcontroller")
    public ResponseEntity<ResponseExample> test(){
        ResponseExample responseExample = new ResponseExample("hello rest");

        return new ResponseEntity<>(responseExample, HttpStatus.OK);
    }

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
