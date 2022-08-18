package com.example.theatherproject.repository;

import com.example.theatherproject.entity.ClassCEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassCRepository extends JpaRepository<ClassCEntity,Long> {
}
