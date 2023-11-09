package com.example.demo.answer.controller;


import com.example.demo.answer.dto.AnserFormDto;
import com.example.demo.answer.service.AnswerService;
import com.example.demo.question.entity.Question;
import com.example.demo.question.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.apache.coyote.http11.Constants.a;

@Controller
@RequiredArgsConstructor
@RequestMapping("/answer")
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model
                             , @PathVariable("id") Integer id
                             , @Valid AnserFormDto AnserFormDto
                             , BindingResult bindingResult){

        Question question = this.questionService.getQuestion(id);
        if(bindingResult.hasErrors()){
            model.addAttribute("question", question);
            return "question_detail";
        }


        answerService.create(AnserFormDto.getContent(),question);
        return String.format("redirect:/question/detail/%s",id);

    }

}
