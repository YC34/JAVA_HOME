package hello.springmvc.basic.requestmapping;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = {"/hello-basic","/hello-go"})
    public String helloBasic(){
        log.info("Hello~Basic");
        return "OK";
    }

    @RequestMapping(value = "/mapping-get-v1",method = RequestMethod.GET)
    public String mappingGetV1(){
        log.info("mappingGetV1");
        return "OK";
    }


    @GetMapping("/mapping-get-v2")
    public String mappingGetV2(){
        log.info("mappingGetV2");
        return "OK";
    }


    /**
     * pathVariable을 사용하여 값을 직접 받을 수 있다.
     * 이름을 같게 하면 생략 가능
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String user /*@PathVariable String userId*/ ){
        log.info("path variable 값 : = {}", user);

        return "OK";

    }


    /**
     *
     * 다중 사용
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId ,@PathVariable Long orderId ){
        log.info("userId  = {} orderId = {}", userId,orderId);

        return "OK";

    }






}
