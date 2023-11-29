package hello.board.basic;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

    //    private final Logger log = LoggerFactory.getLogger(getClass());
    //    위의 @Slf4j으로 대체 할 수 있다.

    @RequestMapping("/log-test")
    public String logTest(){
        String name ="Spring";

        log.trace("trace log ={}",name);
        log.debug("debug log = {}",name);
        log.info("info log = {}", name);
        log.warn("error log = {}",name);
        log.error("error log = {} ",name);
        return "ok";
    }





}
