package com.example.theatherproject.service;

import com.example.theatherproject.dto.QuestionDTO;
import com.example.theatherproject.entity.QuestionEntity;
import com.example.theatherproject.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    public Long save(QuestionDTO questionDTO) {
       QuestionEntity questionEntity = QuestionEntity.save(questionDTO);
        return questionRepository.save(questionEntity).getId();

    }

    public QuestionDTO findById(Long result) {
            Optional<QuestionEntity> optionalQuestionEntity = questionRepository.findById(result);
            if(optionalQuestionEntity.isPresent()){
                QuestionEntity result1 = optionalQuestionEntity.get();
                return QuestionDTO.toQuestionDTO(result1);
            }else{
                return null;
            }

    }
}
