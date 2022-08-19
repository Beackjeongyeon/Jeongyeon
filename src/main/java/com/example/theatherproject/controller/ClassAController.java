package com.example.theatherproject.controller;

import com.example.theatherproject.dto.ClassADTO;
import com.example.theatherproject.service.ClassAService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/classA")
public class ClassAController {
    private final ClassAService classAService;

    @PostMapping("/saveA")
    public String save(@ModelAttribute ClassADTO classADTO){
        Long id = classAService.save(classADTO);
        return "ticketPages/pay";
    }
}
