package com.example.theatherproject.service;

import com.example.theatherproject.dto.MemberDTO;
import com.example.theatherproject.entity.MemberEntity;
import com.example.theatherproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;


    public Long save(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.save(memberDTO);
        return memberRepository.save(memberEntity).getId();

    }


    public MemberDTO login(MemberDTO memberDTO) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByMemberPassword(memberDTO.getMemberPassword());
        if (optionalMemberEntity.isPresent()) {
            if (memberDTO.getMemberPassword().equals(optionalMemberEntity.get().getMemberPassword())) {
                MemberDTO loginDTO = MemberDTO.toMemberDTO(optionalMemberEntity.get());
                return loginDTO;
            } else {
                return null;
            }
        } else {
            return null;
        }

    }
}


