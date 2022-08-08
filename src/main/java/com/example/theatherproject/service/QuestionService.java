package com.example.theatherproject.service;

import com.example.theatherproject.dto.QuestionDTO;
import com.example.theatherproject.entity.MemberEntity;
import com.example.theatherproject.entity.QuestionEntity;
import com.example.theatherproject.repository.MemberRepository;
import com.example.theatherproject.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.engine.spi.ManagedEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final MemberRepository memberRepository;

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

    public QuestionDTO findById(Long memberId) {
         Optional<QuestionEntity> optionalQuestionEntity = questionRepository.findById(memberId);

    }
}
