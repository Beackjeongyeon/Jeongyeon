package com.example.theatherproject.entity;

import com.example.theatherproject.dto.QuestionDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter@Setter
@Table(name = "question_table")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private LocalDateTime questionCreatedTime;

    @Column
    private String questionContents;

    @Column
    private String questionAnswer;

    public static QuestionEntity save(QuestionDTO questionDTO){
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setId(questionDTO.getId());
        questionEntity.setQuestionCreatedTime(questionDTO.getQuestionCreatedTime());
        questionEntity.setQuestionContents(questionDTO.getQuestionContents());
        questionEntity.setQuestionAnswer(questionDTO.getQuestionAnswer());
        return questionEntity;
    }


}
