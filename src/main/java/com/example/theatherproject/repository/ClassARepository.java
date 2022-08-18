package com.example.theatherproject.repository;

import com.example.theatherproject.entity.ClassAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassARepository extends JpaRepository<ClassAEntity,Long> {
}
