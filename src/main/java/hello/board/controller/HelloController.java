package hello.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class HelloController {


    private final Logger logger = LoggerFactory.getLogger(HelloController.class);

    private static final List<Todo> TODO_LIST =
            List.of(new Todo("123","456"),
                    new Todo("1234555","test"));


    @GetMapping("/todos")
    public List<Todo> allTodos(){
       return  TODO_LIST;
    }

    @GetMapping("/users/{username}/todos")
    public Todo todosUser(@PathVariable String username){
        return TODO_LIST.get(0);
    }

    /**
     *
     * post요청에는 CSRF토큰이 필요하다. update, create 등.
     *
     *
     * **/
    @PostMapping("")
    public int createUsert(@PathVariable String username, @RequestBody Todo todo){
        logger.info("username :  {} , todo : {}",username,todo);

        return 1;
    }

}
record Todo (String userNm, String phoneNm){}