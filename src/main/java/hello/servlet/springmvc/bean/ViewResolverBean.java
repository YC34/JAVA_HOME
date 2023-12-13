package hello.servlet.springmvc.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 *
 * Bean으로 등록해줘야하는 prefix,suffix를 application.yml or application.properties에 설정할 수 있다.
 *
 * **/
//@Configuration
//public class ViewResolverBean {
//
//    @Bean
//    ViewResolver InternalResourceViewResolver(){
//        return new InternalResourceViewResolver("/WEB-INF/views/",".jsp");
//    }
//
//
//}
