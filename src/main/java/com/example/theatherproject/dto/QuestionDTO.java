package com.example.theatherproject.dto;

import com.example.theatherproject.entity.MemberEntity;
import com.example.theatherproject.entity.QuestionEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {
    private Long id;
    private LocalDateTime questionCreatedTime;
    private String questionTitle;
    private String questionContents;
    private String questionAnswer;

    private Long memberId;

    public QuestionDTO(LocalDateTime questionCreatedTime, String questionTitle, String questionContents, String questionAnswer, Long memberId) {
        this.questionCreatedTime = questionCreatedTime;
        this.questionTitle = questionTitle;
        this.questionContents = questionContents;
        this.questionAnswer = questionAnswer;
        this.memberId = memberId;
    }

    public static QuestionDTO toQuestionDTO(QuestionEntity result1) {
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setId(result1.getId());
//        questionDTO.setMemberId(result1.getMemberEntity().getId());
        questionDTO.setMemberId(result1.getMemberEntity().getId());
        questionDTO.setQuestionTitle(result1.getQuestionTitle());
        questionDTO.setQuestionContents(result1.getQuestionContents());
        questionDTO.setQuestionAnswer(result1.getQuestionAnswer());
        return questionDTO;
    }
}
