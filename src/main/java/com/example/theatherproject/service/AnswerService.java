package com.example.theatherproject.service;

import com.example.theatherproject.dto.AnswerDTO;
import com.example.theatherproject.entity.AnswerEntity;
import com.example.theatherproject.entity.QuestionEntity;
import com.example.theatherproject.repository.AnswerRepository;
import com.example.theatherproject.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public Long save(AnswerDTO answer) {
        Optional<QuestionEntity> optionalQuestionEntity =  questionRepository.findById(answer.getNumber());
        if(optionalQuestionEntity.isPresent()){
            QuestionEntity questionEntity= optionalQuestionEntity.get();
             Long id = answerRepository.save(AnswerEntity.save(answer,questionEntity)).getId();
            return id;
        }else{
            return null;
        }


    }
}
