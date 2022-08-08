package com.example.theatherproject.controller;

import com.example.theatherproject.dto.QuestionDTO;
import com.example.theatherproject.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/question")
    public String question(){
        return "questionPages/question";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute QuestionDTO questionDTO , Model model){
       Long result=questionService.save(questionDTO);
       QuestionDTO result1= questionService.findById(result);
       model.addAttribute("result",result1);
        return "questionPages/question";
    }
}
