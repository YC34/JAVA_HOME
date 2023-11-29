package com.example.demo.answer.service;


import com.example.demo.answer.entity.Answer;
import com.example.demo.answer.repository.AnswerRepository;
import com.example.demo.question.entity.Question;
import com.example.demo.user.entity.UserAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void create(String content , Question question, UserAccount author){
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        answer.setAuthor(author);
        this.answerRepository.save(answer);

    }
}
