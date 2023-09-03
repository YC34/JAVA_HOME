package hello.board.basic.requestmapping;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class mappingController {

    private Logger log = LoggerFactory.getLogger(getClass());


    @RequestMapping(value = "/hello-basic",method = RequestMethod.GET)
    public String helloBasic(){
        log.info("helloBasic");
        return "ok";
    }
    /***
     *
     * GetMapping 어노테이션은 RequestMapping에 method라고 선언한 것과 같다.
     *
     * */
    @GetMapping(value = "/hello-basic-v2")
    public String helloBasic2(){
        log.info("helloBasic");
        return "ok";
    }



    /**
     * 요청에서 URL에 직접 경로를 보내준다.
     * 경로 변수를 사용.
     * @PathVariable로 받아서 사용한다.
     *
     * **/

    @GetMapping(value = "/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data){
        log.info("mappingPath userId ={} ",data);
        return "ok";
    }

    /**
     * PathVariable 다중 사용도 가능.
     *
     * **/
    @GetMapping(value = "/mapping/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable("userId") String data,@PathVariable("orderId") Long id){
        log.info("mappingPath userId ={} ",data);
        log.info("mappingPath orderId ={} ",id);
        return "ok";
    }


    /**
     *
     * params옵션을 이용하면, 특정 파라미터가 없으면 호출이 되지않는다.
     * params = "mode"
     * params = "!mode"
     * params = "mode=debug"
     * params = "mode!=debug"
     * params = {"mode=debug","data=good"}
     * **/
    @GetMapping(value = "/mapping-param",params = "mode=debug")
    public String mappingParam(){
        log.info("mappingParam");
        return "ok";
    }

    /**
     *
     * header에도 특정한 값을 맵핑할 수 있다.
     *
     * **/

    @GetMapping(value = "/mapping-param",headers = "mode=debug")
    public String mappingHeader(){
        log.info("mappingHeader");
        return "ok";
    }
}
