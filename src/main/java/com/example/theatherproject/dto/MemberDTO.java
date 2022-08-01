package com.example.theatherproject.dto;

import com.example.theatherproject.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {

    private Long id;
    private String memberId;
    private String memberPassword;

    private String memberPassword2;
    private String memberName;
    private int memberAge;
    private String memberEmail;
    private String memberPhone;
    private LocalDateTime memberCreatedTime;

    public MemberDTO(String memberId, String memberPassword, String memberPassword2, String memberName, int memberAge, String memberEmail, String memberPhone, LocalDateTime memberCreatedTime) {
        this.memberId = memberId;
        this.memberPassword = memberPassword;
        this.memberPassword2 = memberPassword2;
        this.memberName = memberName;
        this.memberAge = memberAge;
        this.memberEmail = memberEmail;
        this.memberPhone = memberPhone;
        this.memberCreatedTime = memberCreatedTime;
    }

    public static MemberDTO toMemberDTO(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setMemberId(memberEntity.getMemberId());
        memberDTO.setMemberPassword(memberEntity.getMemberPassword());
        memberDTO.setMemberPassword2(memberEntity.getMemberPassword2());
        memberDTO.setMemberName(memberEntity.getMemberName());
        memberDTO.setMemberAge(memberEntity.getMemberAge());
        memberDTO.setMemberEmail(memberEntity.getMemberEmail());
        memberDTO.setMemberPhone(memberEntity.getMemberPhone());
        return memberDTO;
    }
    public static MemberDTO toPw2(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberPassword2(memberEntity.getMemberPassword2());
        return memberDTO;
    }

}
