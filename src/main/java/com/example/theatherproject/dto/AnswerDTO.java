package com.example.theatherproject.dto;

import com.example.theatherproject.entity.AnswerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDTO {

    private Long id;
    private String answer;
    private Long number;

    public AnswerDTO(String answer, Long number) {
        this.answer = answer;
        this.number = number;
    }


    public static AnswerDTO saveDTO(AnswerEntity answerEntity){
        AnswerDTO answerDTO = new AnswerDTO();
        answerDTO.setId(answerEntity.getId());
        answerDTO.setAnswer(answerEntity.getAnswer());
        answerDTO.setNumber(answerEntity.getNumber());
        return answerDTO;
    }

//    public static AnswerDTO save1DTO(AnswerEntity answerEntity) {
//        AnswerDTO answerDTO = new AnswerDTO();
//        answerDTO.setAnswer(answerEntity.getAnswer());
//        answerDTO.setNumber(answerDTO.getNumber());
//    }
}
