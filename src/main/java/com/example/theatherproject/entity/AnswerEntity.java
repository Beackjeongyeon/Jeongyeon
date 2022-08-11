package com.example.theatherproject.entity;
import com.example.theatherproject.dto.AnswerDTO;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter @Setter
@Table(name = "answer_table")
public class AnswerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name= "answer")
    private String answer;

    @Column
    private Long number;

    @OneToOne
    @MapsId
    @JoinColumn(name = "question_Id")
    private QuestionEntity questionEntity;



    public static AnswerEntity save(AnswerDTO answerDTO, QuestionEntity questionEntity){
        AnswerEntity answerEntity = new AnswerEntity();
        answerEntity.setId(answerDTO.getId());
        answerEntity.setAnswer(answerDTO.getAnswer());
        answerEntity.setNumber(questionEntity.getId());
        answerEntity.setQuestionEntity(questionEntity);
        return answerEntity;

    }

}
