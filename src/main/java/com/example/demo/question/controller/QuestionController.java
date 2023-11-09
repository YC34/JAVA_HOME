package com.example.demo.question.controller;

import com.example.demo.question.entity.Question;
import com.example.demo.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService service;

    private Logger log = LoggerFactory.getLogger(getClass());
    @GetMapping("/list")
    public String list(Model model) {
        List<Question> question = service.getList();
        model.addAttribute("questionList",question);
        return "question_list";
    }


    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question question = this.service.getQuestion(id);
        model.addAttribute("question",question);

        return "question_detail";
    }




}
