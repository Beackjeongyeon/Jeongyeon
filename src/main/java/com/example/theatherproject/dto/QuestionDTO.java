package com.example.theatherproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {
    private Long id;
    private LocalDateTime questionCreatedTime;
    private String questionContents;
    private String questionAnswer;

    public QuestionDTO(LocalDateTime questionCreatedTime, String questionContents, String questionAnswer) {
        this.questionCreatedTime = questionCreatedTime;
        this.questionContents = questionContents;
        this.questionAnswer = questionAnswer;
    }
}
