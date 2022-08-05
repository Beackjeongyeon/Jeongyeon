package com.example.theatherproject.service;

import com.example.theatherproject.dto.NoticeDTO;
import com.example.theatherproject.entity.NoticeEntity;
import com.example.theatherproject.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public Long save(NoticeDTO noticeDTO) throws IOException {
        MultipartFile noticeFile = noticeDTO.getNoticeFile();
        String noticeFileName = noticeFile.getOriginalFilename();
        noticeFileName = System.currentTimeMillis() + "_" + noticeFileName;
        String savePath = "D:\\notice_img\\" + noticeFileName;
        if (!noticeFile.isEmpty()) {
            noticeFile.transferTo(new File(savePath));
        }
      noticeDTO.setNoticeFileName(noticeFileName);
        NoticeEntity noticeEntity = NoticeEntity.save(noticeDTO);
        return noticeRepository.save(noticeEntity).getId();
    }
}
