package com.example.theatherproject.service;

import com.example.theatherproject.dto.ClassBDTO;
import com.example.theatherproject.entity.ClassBEntity;
import com.example.theatherproject.repository.ClassARepository;
import com.example.theatherproject.repository.ClassBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassBService {
    private final ClassBRepository classBRepository;

}
