package com.example.demo.question.controller;

import com.example.demo.answer.dto.AnserFormDto;
import com.example.demo.question.dto.QuestionFormDto;
import com.example.demo.question.entity.Question;
import com.example.demo.question.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String detail(Model model
                       , @PathVariable("id") Integer id
                       , AnserFormDto anserFormDto) {
        Question question = this.service.getQuestion(id);
        model.addAttribute("question",question);

        return "question_detail";
    }

    @GetMapping("/create")
    public String questionCreate(QuestionFormDto questionFormDto) {
        return "question_form";
    }



    /**
     *
     * @description @Valid 어노테이션을 거친 객체를 바인딩 한 객체가 BindingResult
     *
     * **/
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionFormDto QuestionFormDto , BindingResult bindingResult) {
        log.info("BindResult : {}",bindingResult);

        if(bindingResult.hasErrors()){
            return "question_form";
        }


        this.service.create(QuestionFormDto.getSubject(),QuestionFormDto.getContent());
        return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
    }




}
