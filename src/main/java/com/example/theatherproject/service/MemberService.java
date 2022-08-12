package com.example.theatherproject.service;

import com.example.theatherproject.dto.MemberDTO;
import com.example.theatherproject.entity.BoardEntity;
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
        System.out.println("MemberService.save");
        System.out.println("memberDTO = " + memberDTO);
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

    public MemberDTO findById(Long id) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(id);
        if (optionalMemberEntity.isPresent()) {
            MemberEntity result = optionalMemberEntity.get();
            return MemberDTO.toMemberDTO(result);
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        memberRepository.deleteById(id);
    }


    public MemberDTO Check(Long memberId, String memberPassword2) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(memberId);
        MemberEntity memberEntity = new MemberEntity();
        if (optionalMemberEntity.isPresent()) {
            memberEntity = optionalMemberEntity.get();
            if (memberEntity.getMemberPassword2().equals(memberPassword2)) {
                MemberDTO checkDTO = MemberDTO.toPw2(memberEntity);
                return checkDTO;
            } else {
                return null;
            }
        } else {
            return null;
        }

    }

    public void update(MemberDTO memberDTO) {
        memberRepository.save(MemberEntity.entityUpdate(memberDTO));
    }
}


