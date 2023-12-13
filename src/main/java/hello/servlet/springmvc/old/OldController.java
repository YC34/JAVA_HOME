package hello.servlet.springmvc.old;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


/**
 *
 * spring bean의 이름이 component에 명시한 이름이 된다.
 * 우선순위는 @RequestMapping이다.
 *
 * **/

@Slf4j
@Component("/springmvc/old-controller")
public class OldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info("OldController.handleRequest");
        return new ModelAndView("new-form");
        /**
         * suffix,prefix를 bean으로 등록하는 방법 springmbvc.bean.ViewResolverBean
         * **/
    }
}
