package com.example.theatherproject.repository;

import com.example.theatherproject.entity.ClassAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassARepository extends JpaRepository<ClassAEntity,Long> {

     List<ClassAEntity>findByTicketDate(String ticketDate);
}
