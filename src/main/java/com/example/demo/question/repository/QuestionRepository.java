package com.example.demo.question.repository;

import com.example.demo.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

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




}
