package hello.servlet.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {

    /**
     * @Param paramMap
     * @Param model
     * @return String type의 viewName.
     *
     * **/
    String process(Map<String,String> paramMap, Map<String,Object> model);
}
