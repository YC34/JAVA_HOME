package com.example.demo;

import com.example.demo.answer.entity.Answer;
import com.example.demo.question.entity.Question;
import com.example.demo.answer.repository.AnswerRepository;
import com.example.demo.question.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class QuestionTest {
    @Autowired
    private QuestionRepository questionRepository;

    private final Logger log = LoggerFactory.getLogger(getClass());
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

        Optional<Question> uq = this.questionRepository.findById(1);
        Question data = uq.get();
        log.info("select : {} ",data.getSubject());

        data.setSubject("수정된 제목");
        this.questionRepository.save(data);

        log.info("select : {} ", data.getSubject());




    }


    @Test
    void deleteQuestion(){

        /**
         * 데이터 총 건수 확인 후 삭제
         *
         * **/

        assertEquals(2,questionRepository.count());
        Optional<Question> uq = this.questionRepository.findById(1);
        // Optional에 값이 있는지만 체크 있으면 true , 없으면 false를 반환한다.
        assertTrue(uq.isPresent());

        Question data = uq.get();
        this.questionRepository.delete(data);
        assertEquals(1,questionRepository.count());

    }


    /**
     *
     * Answer 테이블에 답변 생성
     *
     * **/

    @Autowired
    private AnswerRepository answerRepository;

    @Test
    void insertAnswer(){
        // 1번 아이디는 삭제 하였다.
        Optional<Question> sq = this.questionRepository.findById(2);
        // 존재하는지 확인
        assertTrue(sq.isPresent());
        Question data = sq.get();

        Answer as = new Answer();
        as.setContent("네 자동으로 생성됩니다.");
        as.setQuestion(data);
        as.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(as);

        assertEquals(1,this.answerRepository.count());

    }



}
