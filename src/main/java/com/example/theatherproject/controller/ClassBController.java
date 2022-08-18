package com.example.theatherproject.controller;

import com.example.theatherproject.dto.ClassBDTO;
import com.example.theatherproject.service.ClassBService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/classB")
public class ClassBController {
    private final ClassBService classBService;


}
