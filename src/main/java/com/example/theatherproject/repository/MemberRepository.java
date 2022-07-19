package com.example.theatherproject.repository;

import com.example.theatherproject.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
}
