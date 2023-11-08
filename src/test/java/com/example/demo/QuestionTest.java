package com.example.demo;

import com.example.demo.entity.Question;
import com.example.demo.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class QuestionTest {
    @Autowired
    private QuestionRepository questionRepository;
    @Test
    void insertQuestion() {
        Question q1 = new Question();
        q1.setSubject("sbb가 무엇인가요?");
        q1.setContent("sbb에 대해서 알고 싶습니다.");
        q1.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q1);  // 첫번째 질문 저장

        Question q2 = new Question();
        q2.setSubject("스프링부트 모델 질문입니다.");
        q2.setContent("id는 자동으로 생성되나요?");
        q2.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q2);  // 두번째 질문 저장

    }


    @Test
    void selectQuestionAll(){
        List<Question> all = this.questionRepository.findAll();
        assertEquals(2, all.size());

        Question q = all.get(0);
        assertEquals("sbb가 무엇인가요?", q.getSubject());

    }


    @Test
    void selectQuestionOne(){
        Optional<Question> oq = this.questionRepository.findById(1);
        if(oq.isPresent()) {
            Question q = oq.get();
            assertEquals("sbb가 무엇인가요?", q.getSubject());
        }



    }

    @Test
    void selectSubject(){
        Question q1 = questionRepository.findBySubject("sbb가 무엇인가요?");
        assertEquals(1,q1.getId());


    }

    @Test
    void selectSubjectAndContent(){
        Question q1 = questionRepository.findBySubjectAndContent("sbb가 무엇인가요?","sbb에 대해서 알고 싶습니다.");
        assertEquals(1,q1.getId());


    }

    @Test
    void selectSubjectLike(){

        /**
         * 모든 sbb가 있는 데이터 조회해야 하므로 List형태로 담았다.
         * 첫번째가 sbb인것을 알고 있으므로, 확인한다. List의 get함수를 사용한다.
         *
         * **/


        List<Question> qq = questionRepository.findBySubjectLike("sbb%");
        Question q2 = qq.get(0);
        assertEquals("sbb가 무엇인가요?", q2.getSubject());


    }


    @Test
    void updateQuestion(){
        /**
         *
         * JpaRepository 위의 CrudRepository의 save()메소드 활용
         *
         * **/





    }


}
