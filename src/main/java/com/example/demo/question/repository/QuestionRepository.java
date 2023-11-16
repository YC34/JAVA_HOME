package com.example.demo.question.repository;

import com.example.demo.question.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



/**
 *
 * mybatis와는 다르게, JPA는 ORM(Object Relational Mapping)을 사용하여
 * 개발자가 바뀌어도 통일된 쿼리를 작성할 수 있고 오류 발생률도 줄일 수 있다.
 * entity에 의해 생성된 테이블에 대한 CRUD를 하기 위한 인터페이스.
 *
 * **/
public interface QuestionRepository extends JpaRepository<Question,Integer> {


    /**
     *
     * @param subject
     * @description subject를 통한 조회
     *
     * **/
    Question findBySubject(String subject);



    /**
     *
     * @param subject
     * @param content
     * @descrpiton 문자형태로 된 subject,content 두가지
     *
     * **/

    Question findBySubjectAndContent(String subject,String content);




    /**
     *
     * @param subject
     * @description 쿼리문의 Like와 비슷한 형태
     * **/

    List<Question> findBySubjectLike(String subject);



    /**
     *
     * @param pageable
     * @description JPA에서 지원하는 Page객체를 이용한 paging처리
     *
     * **/
    Page<Question> findAll(Pageable pageable);



}
