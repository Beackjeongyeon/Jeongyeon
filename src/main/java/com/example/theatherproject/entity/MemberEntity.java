package com.example.theatherproject.entity;

import com.example.theatherproject.dto.MemberDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "member_table")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="member_Id")
    private Long id;

    @Column(length = 20)
    private String userId;

    @Column(length = 20)
    private String memberPassword;

    @Column(length = 20)
    private String memberPassword2;

    @Column(name ="member_Name")
    private String memberName;

    @Column
    private int memberAge;

    @Column
    private String memberEmail;

    @Column
    private String memberPhone;

    @Column
    @CreationTimestamp
    private LocalDateTime memberCreatedTime;


    @OneToMany(mappedBy = "memberEntity",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<QuestionEntity> questionList = new ArrayList<>();


    public static MemberEntity save(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUserId(memberDTO.getUserId());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        memberEntity.setMemberPassword2(memberDTO.getMemberPassword2());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberAge(memberDTO.getMemberAge());
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberPhone(memberDTO.getMemberPhone());
        memberEntity.setMemberCreatedTime(memberDTO.getMemberCreatedTime());
        return memberEntity;

    }

    public static MemberEntity entityUpdate(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberDTO.getId());
        memberEntity.setUserId(memberDTO.getUserId());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        memberEntity.setMemberPassword2(memberDTO.getMemberPassword2());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberAge(memberDTO.getMemberAge());
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberPhone(memberDTO.getMemberPhone());
        return memberEntity;
    }
}
