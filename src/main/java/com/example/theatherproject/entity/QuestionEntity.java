package com.example.theatherproject.entity;

import com.example.theatherproject.dto.AnswerDTO;
import com.example.theatherproject.dto.QuestionDTO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "question_table")
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_Id")
    private Long id;

    @Column
    private String questionTitle;

    @Column
    private String questionContents;

    @Column
    private String questionAnswer;

    @Column
    @CreationTimestamp
    private LocalDateTime createdTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_Id")
    private MemberEntity memberEntity;

    @OneToOne(mappedBy = "questionEntity",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private AnswerEntity answerEntity;



    public static QuestionEntity save(QuestionDTO questionDTO, MemberEntity memberEntity) {
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setId(questionDTO.getId());
        questionEntity.setMemberEntity(memberEntity);
        questionEntity.setCreatedTime(questionDTO.getCreatedTime());
        questionEntity.setQuestionTitle(questionDTO.getQuestionTitle());
        questionEntity.setQuestionContents(questionDTO.getQuestionContents());
        return questionEntity;
    }
    public static QuestionEntity updateQuestion(QuestionDTO questionDTO,MemberEntity memberEntity, AnswerEntity answerEntity){
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setId(questionDTO.getId());
        questionEntity.setQuestionTitle(questionDTO.getQuestionTitle());
        questionEntity.setQuestionContents(questionDTO.getQuestionContents());
        questionEntity.setQuestionAnswer(answerEntity.getAnswer());
        questionEntity.setAnswerEntity(answerEntity);
        questionEntity.setMemberEntity(memberEntity);
        questionEntity.setCreatedTime(questionDTO.getCreatedTime());
        return questionEntity;
    }



}
