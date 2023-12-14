package hello.springmvc.basic;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTestController {


    // 추후에는 어노테이션을 사용함.
    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logtest(){
        String name = "park";
        log.info("name = {}",name);

        return "OK";
    }


}
