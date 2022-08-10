package com.example.theatherproject.service;

import com.example.theatherproject.dto.AnswerDTO;
import com.example.theatherproject.dto.QuestionDTO;
import com.example.theatherproject.entity.AnswerEntity;
import com.example.theatherproject.entity.MemberEntity;
import com.example.theatherproject.entity.QuestionEntity;
import com.example.theatherproject.repository.AnswerRepository;
import com.example.theatherproject.repository.MemberRepository;
import com.example.theatherproject.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.engine.spi.ManagedEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final MemberRepository memberRepository;
    private final AnswerRepository answerRepository;

    public Long save(QuestionDTO questionDTO) {
        Optional<MemberEntity> optionalMemberEntity =
                memberRepository.findById(questionDTO.getMemberId());
        if (optionalMemberEntity.isPresent()) {
            MemberEntity memberEntity = optionalMemberEntity.get();
            Long id = questionRepository.save(QuestionEntity.save(questionDTO, memberEntity)).getMemberEntity().getId();
            return id;
        } else {
            return null;

        }

    }


    @Transactional
    public List<QuestionDTO> findAll() {
        List<QuestionEntity> questionEntityList = questionRepository.findAll();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (QuestionEntity questionEntity : questionEntityList) {
            questionDTOList.add(QuestionDTO.toQuestionDTO(questionEntity));
        }
        return questionDTOList;
    }

    public QuestionDTO findById(Long id) {
        Optional<QuestionEntity> optionalQuestionEntity = questionRepository.findById(id);
        if (optionalQuestionEntity.isPresent()) {
            QuestionEntity questionEntity = optionalQuestionEntity.get();
            return QuestionDTO.toQuestionDTO(questionEntity);
        }
        return null;
    }


    public void saveId(Long id) {
        Optional<AnswerEntity> optionalAnswerEntity = answerRepository.findById(id);
        String answer = optionalAnswerEntity.get().getAnswer();
        Optional<QuestionEntity> byId = questionRepository.findById(id);
        if (byId.isPresent()) {
            QuestionEntity questionEntity = byId.get();
            questionEntity.setQuestionContents(questionEntity);
        }
    }
}
