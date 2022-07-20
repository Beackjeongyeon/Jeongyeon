package com.example.theatherproject.entity;

import com.example.theatherproject.dto.MemberDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter@Setter
@Table(name = "member_table")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(length =20)
    private String memberId;

    @Column(length = 20)
    private String memberPassword;

    @Column
    private String memberName;

    @Column
    private int memberAge;

    @Column
    private String memberEmail;

    @Column
    private String memberPhone;

    @Column
    private LocalDateTime memberCreatedTime;

    public static MemberEntity save(MemberDTO memberDTO){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberId(memberDTO.getMemberId());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberAge(memberDTO.getMemberAge());
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberPhone(memberDTO.getMemberPhone());
        memberEntity.setMemberCreatedTime(memberDTO.getMemberCreatedTime());
        return memberEntity;

    }
}
