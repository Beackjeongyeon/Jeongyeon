package com.example.theatherproject.entity;

import com.example.theatherproject.dto.NoticeDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter@Setter
@Table(name = "notice")
public class NoticeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String noticeTitle;

    @Column
    private String noticeContents;

    @Column
    private String noticeFileName;

    @Column
    private int noticeHits;

    public static NoticeEntity save(NoticeDTO noticeDTO, NoticeEntity noticeEntity){
        NoticeEntity noticeEntity1 = new NoticeEntity();
        noticeEntity1.setId(noticeDTO.getId());
        noticeEntity1.setNoticeTitle(noticeDTO.getNoticeTitle());
        noticeEntity1.setNoticeContents(noticeDTO.getNoticeContents());
        noticeEntity1.setNoticeHits(noticeDTO.getNoticeHits());
        noticeEntity1.setNoticeFileName(noticeDTO.getNoticeFileName());
        return noticeEntity;

    }


}
