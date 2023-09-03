package hello.board.basic.requestmapping;


import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    @GetMapping
    public String user(){
        return "get user";
    }
    @PostMapping
    public String addUSer(){
        return "post user";
    }
    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId){
        return "findUser"+userId;
    }

    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId){
        return "update User"+userId;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId){
        return "delete User"+userId;
    }


}
