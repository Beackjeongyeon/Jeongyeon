package com.example.theatherproject.service;
import com.example.theatherproject.dto.MemberDTO;
import com.example.theatherproject.entity.MemberEntity;
import com.example.theatherproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;


    public Long save(MemberDTO memberDTO) {
        MemberEntity memberEntity= MemberEntity.save(memberDTO);
        return memberRepository.save(memberEntity).getId();

    }
}
