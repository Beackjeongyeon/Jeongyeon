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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "member_Id")
    private MemberEntity memberEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "question_Id")
    private QuestionEntity questionEntity;

    @OneToMany(mappedBy = "answerEntity", cascade = CascadeType.REMOVE, orphanRemoval = true,
    fetch = FetchType.LAZY)
    private List<QuestionEntity> questionList = new ArrayList<>();

    public static AnswerEntity save(AnswerDTO answerDTO,QuestionEntity questionEntity){
        AnswerEntity answerEntity = new AnswerEntity();
        answerEntity.setId(answerDTO.getId());
        answerEntity.setAnswer(answerDTO.getAnswer());
        answerEntity.setNumber(questionEntity.getId());
        return answerEntity;

    }

}
