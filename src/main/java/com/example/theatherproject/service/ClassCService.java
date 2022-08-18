package com.example.theatherproject.service;

import com.example.theatherproject.dto.ClassCDTO;
import com.example.theatherproject.entity.ClassCEntity;
import com.example.theatherproject.repository.ClassCRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassCService {
    private final ClassCRepository classCRepository;

}
