package com.example.theatherproject.repository;

import com.example.theatherproject.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity,Long> {

    @Override
    Optional<BoardEntity> findById(Long id);
}
