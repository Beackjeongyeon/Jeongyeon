package com.example.theatherproject.repository;

import com.example.theatherproject.entity.BoardEntity;
import com.example.theatherproject.entity.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoticeRepository extends JpaRepository<NoticeEntity,Long> {
    Optional<NoticeEntity> findByNoticeTitle(String noticeTitle);
}
