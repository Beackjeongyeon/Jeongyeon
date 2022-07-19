package com.example.theatherproject.entity;

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
    private int memberPassword;

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




}
