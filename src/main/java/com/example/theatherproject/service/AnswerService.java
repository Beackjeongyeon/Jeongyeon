package com.example.theatherproject.service;

import com.example.theatherproject.dto.AnswerDTO;
import com.example.theatherproject.dto.MemberDTO;
import com.example.theatherproject.dto.QuestionDTO;
import com.example.theatherproject.entity.AnswerEntity;
import com.example.theatherproject.entity.MemberEntity;
import com.example.theatherproject.entity.QuestionEntity;
import com.example.theatherproject.repository.AnswerRepository;
import com.example.theatherproject.repository.MemberRepository;
import com.example.theatherproject.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final MemberRepository memberRepository;

    public void save(AnswerDTO answerDTO) {
        Optional<QuestionEntity> optionalQuestionEntity = questionRepository.findById(answerDTO.getNumber());
        if (optionalQuestionEntity.isPresent()) {
            QuestionDTO questionDTO = QuestionDTO.toQuestionDTO(optionalQuestionEntity.get());
            Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(questionDTO.getMemberId());
            if (optionalMemberEntity.isPresent()) {
                QuestionEntity questionEntity = optionalQuestionEntity.get();
                MemberEntity memberEntity = optionalMemberEntity.get();
                AnswerEntity answerEntity = AnswerEntity.save(answerDTO, questionEntity);
                answerRepository.save(answerEntity);
                questionRepository.save(QuestionEntity.updateQuestion(questionDTO,memberEntity, answerEntity));
            }
        }
    }
}
