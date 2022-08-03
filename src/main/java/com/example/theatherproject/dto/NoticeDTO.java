package com.example.theatherproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeDTO {
    private Long id;
    private String noticeContents;
    private String noticePhoto;

    public NoticeDTO(String noticeContents, String noticePhoto) {
        this.noticeContents = noticeContents;
        this.noticePhoto = noticePhoto;
    }
}
