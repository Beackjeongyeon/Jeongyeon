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
    private String questionTitle;

    @Column
    private String questionContents;

    @Column
    private String questionAnswer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_Id")
    private MemberEntity memberEntity;



    public static QuestionEntity save(QuestionDTO questionDTO, MemberEntity memberEntity){
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setId(questionDTO.getId());
        questionEntity.setMemberEntity(memberEntity);
        questionEntity.setQuestionTitle(questionDTO.getQuestionTitle());
        questionEntity.setQuestionCreatedTime(questionDTO.getQuestionCreatedTime());
        questionEntity.setQuestionContents(questionDTO.getQuestionContents());
        questionEntity.setQuestionAnswer(questionDTO.getQuestionAnswer());
        return questionEntity;
    }


}
