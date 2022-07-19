package com.example.theatherproject.dto;

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
    private int memberPassword;
    private String memberName;
    private int memberAge;
    private String memberEmail;
    private String memberPhone;
    private LocalDateTime memberCreatedTime;

    public MemberDTO(String memberId, int memberPassword, String memberName, int memberAge, String memberEmail, String memberPhone, LocalDateTime memberCreatedTime) {
        this.memberId = memberId;
        this.memberPassword = memberPassword;
        this.memberName = memberName;
        this.memberAge = memberAge;
        this.memberEmail = memberEmail;
        this.memberPhone = memberPhone;
        this.memberCreatedTime = memberCreatedTime;
    }
}
