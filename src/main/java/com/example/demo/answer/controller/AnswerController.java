package com.example.demo.answer.controller;


import com.example.demo.answer.service.AnswerService;
import com.example.demo.question.entity.Question;
import com.example.demo.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/answer")
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(@PathVariable("id") Integer id
                             , @RequestParam String content){

        Question question = this.questionService.getQuestion(id);
        answerService.create(content,question);
        return String.format("redirect:/question/detail/%s",id);

    }

}
