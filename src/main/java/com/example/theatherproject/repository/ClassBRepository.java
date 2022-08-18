package com.example.theatherproject.repository;

import com.example.theatherproject.entity.ClassBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassBRepository extends JpaRepository<ClassBEntity , Long> {
}
