package com.example.theatherproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeDTO {
    private Long id;
    private String noticeTitle;
    private String noticeContents;
    private String noticeFileName;
    private MultipartFile noticeFile;
    private LocalDateTime createdTime;
    private int noticeHits;

    public NoticeDTO(String noticeTitle, String noticeContents, String noticeFileName, MultipartFile noticeFile, LocalDateTime createdTime, int noticeHits) {
        this.noticeTitle = noticeTitle;
        this.noticeContents = noticeContents;
        this.noticeFileName = noticeFileName;
        this.noticeFile = noticeFile;
        this.createdTime = createdTime;
        this.noticeHits = noticeHits;
    }
}
