package com.example.demo.question.controller;

import com.example.demo.answer.dto.AnswerFormDto;
import com.example.demo.question.dto.QuestionFormDto;
import com.example.demo.question.entity.Question;
import com.example.demo.question.service.QuestionService;
import com.example.demo.user.entity.UserAccount;
import com.example.demo.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService service;
    private final UserService userService;
    private Logger log = LoggerFactory.getLogger(getClass());
    @GetMapping("/list")
    public String list(Model model
                     , @RequestParam(value = "page",defaultValue = "0") int page) {
        Page<Question> paging = this.service.getList(page);
        model.addAttribute("paging", paging);
        return "question_list";
    }


    @GetMapping(value = "/detail/{id}")
    public String detail(Model model
                       , @PathVariable("id") Integer id
                       , AnswerFormDto answerFormDto) {
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
    public String questionCreate(@Valid QuestionFormDto QuestionFormDto
            , BindingResult bindingResult
            , Principal principal) {
        log.info("BindResult : {}",bindingResult);

        if(bindingResult.hasErrors()){
            return "question_form";
        }

        UserAccount userAccount = this.userService.getUser(principal.getName());
        this.service.create(QuestionFormDto.getSubject(),QuestionFormDto.getContent(),userAccount);
        return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
    }




}
