package hello.board.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 *
 * DB 연동 config파일 mybatis 사용시.
 *
 * @Configuration : 스프링 부트 환결설정 클래스임을 명시, 자동으로 빈 등록.
 *
 * 기존의 new로 객체를 선언해서 관리했던 부분을 @ComponentScan할떄(메인 메소드에 SpringBootApplication안에 포함되어있음.)
 * @Bean으로 선언되어있는 모든 빈들도 IoC(Inversion of Control) 컨테이너에 등록
 *
 * @PropertySource application.properties에 선언된 정보들을 읽어온다.
 * **/
@Configuration
@PropertySource("classpath:/application.properties")
public class DBconfig {
    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * hikari CP(Connection Pool) 객체를 생성.
     * @Bean 리턴되는 객체를 IoC컨터이너에 등록
     * 특별한 이름이 없다면, 해당 메소드명으로 지정. 이름 지정도 커스터마이징 가능.
     *  01. HikariConfig
     *  02. HikariDataSource
     * **/

    /**
     * 01. HikariConfig 객체 생성
     *     application.properties 파일로 부터 데이터베이스 관련된 정보를 읽어와서 히카리 설정 객체를 리턴.
     *     해당 접두어로 시작하는 정보들을 읽어온다.
     * **/

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig(){
        return new HikariConfig();
    }

    /**
     * 02. HikariDataSource 객체 생성
     * **/
    @Bean
    public DataSource dataSource(){
        DataSource dataSource = new HikariDataSource(hikariConfig());
        log.info("datasource = {}",dataSource.toString());
        return dataSource;
    }

    /**
     *
     * Mybatis 설정.
     *  01. SqlSessionFactiory <---- SqlSessionFactoryBean
     *  02. SqlSessionTemplate <---- SqlSessionFactory
     *
     * **/


    /**
     *
     * 01. SqlSessionFactiory객체 생성
     *     이떄, dataSource객체를 넘겨 받아 처리.
     *
     * 기본적인 설정 3가지
     *  A. serDataSource : 빌드 된 DataSource를 셋팅
     *  B. setMapperLocations : sql구문이 작성된 "Mapper.xml"의 경로
     *  C. setTypeAliasesPackage : 인자로 Aliases 대상 클래스가 위치한 패키지 경로.
     *
     *
     *  주의 사항
     *  SqlSessionFactiory에 저장할 config 설정 시 Mapper에서 사용하고자 하는 DTO,VO,Entity에 대해서
     *  setTypeAliasesPackage 저장 필요.
     *  만약 지정해주지 않는다면 alias 찾지 못한다는 오류가 발생할 수 있음.
     *
     * **/

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/*Mapper.xml"));

        /**
         *  mapper파일은 어디서 가져오나.
         *  ApplicationContext에서 가져올 수 있다.(컨테이너..?)
         *  ApplicationContext는 프레임워크의 컨테이너..???빈을 등록하는 컨테이너?
         *  ApplicationContext는 애플리케이션이 스타트해서 끝나는 순간까지
         *                      이 애플리케이션에서 필요한 모든 자원들을 모아놓고 관리하는 객체?
         *
         * **/

        factoryBean.setTypeAliasesPackage("hello.board.dto");

        return factoryBean.getObject();
    }


    /**
     * 02. SqlSessionTemplate객체 생성
     *    >>> 01.번의 인자를 받아서 객체를 생성.
     *    실질적인 역할을 하는 객체.
     *    SQL 구문의 실행과 트랜잭션 등을 관리하는..등등
     *    Mybatis의 sqlSession 객체가 Spring+mybatis 연동 모듈에서는 sqlSessionTemplate의 대체
     *
     * **/
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception{

        return new SqlSessionTemplate(sqlSessionFactory);
    }



}
