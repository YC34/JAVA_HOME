package com.example.demo.answer.controller;


import com.example.demo.answer.dto.AnswerFormDto;
import com.example.demo.answer.service.AnswerService;
import com.example.demo.question.entity.Question;
import com.example.demo.question.service.QuestionService;
import com.example.demo.user.entity.UserAccount;
import com.example.demo.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/answer")
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;
    private final UserService userService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model
                             , @PathVariable("id") Integer id
                             , @Valid AnswerFormDto answerFormDto
                             , BindingResult bindingResult
                             , Principal principal){

        Question question = this.questionService.getQuestion(id);
        UserAccount userAccount = this.userService.getUser(principal.getName());
        if(bindingResult.hasErrors()){
            model.addAttribute("question", question);
            return "question_detail";
        }


        answerService.create(answerFormDto.getContent(),question,userAccount);
        return String.format("redirect:/question/detail/%s",id);

    }

}
