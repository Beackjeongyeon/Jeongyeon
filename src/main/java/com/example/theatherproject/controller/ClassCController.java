package com.example.theatherproject.controller;

import com.example.theatherproject.dto.ClassBDTO;
import com.example.theatherproject.dto.ClassCDTO;
import com.example.theatherproject.service.ClassCService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/classC")
public class ClassCController {
    private final ClassCService classCService;


}
