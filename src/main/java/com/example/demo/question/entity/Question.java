package com.example.demo.question.entity;


import com.example.demo.answer.entity.Answer;
import com.example.demo.user.entity.UserAccount;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


/**
 *
 * Entity
 * DB의 테이블과 1:1맵핑되는 클래스 table명을 명시해 줄 수 도 있다.
 * 각종 어노테이션을 통해 , 옵션을 지정할 수 있다.
 *
 * **/
@Getter
@Setter
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

    @ManyToOne
    private UserAccount author;

}
