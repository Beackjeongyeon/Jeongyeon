package com.example.theatherproject.repository;

import com.example.theatherproject.entity.MemberEntity;
import com.example.theatherproject.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity ,Long> {
}
