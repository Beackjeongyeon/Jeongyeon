package com.example.theatherproject.controller;

import com.example.theatherproject.dto.QuestionDTO;
import com.example.theatherproject.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/question")
    public String question(){
        return "questionPages/save";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute QuestionDTO questionDTO){
        Long result = questionService.save(questionDTO);
        System.out.println(result);
        return "redirect:/";
    }
    @GetMapping("/list")
    public String list(@ModelAttribute QuestionDTO questionDTO,Model model){
        List<QuestionDTO> questionDTOList= questionService.findAll();
        model.addAttribute("result", questionDTOList);
        return "questionPages/list";
    }
    @GetMapping("/adminlist")
    public String adminlist(@ModelAttribute QuestionDTO questionDTO,Model model){
        List<QuestionDTO> questionDTOList= questionService.findAll();

        model.addAttribute("result", questionDTOList);
        return "questionPages/adminlist";
    }
    @GetMapping("/clickEvent/{id}")
    public String clickEvent(@PathVariable Long id, Model model){
        System.out.println(id);
   QuestionDTO questionDTO = questionService.findById(id);
   model.addAttribute("question", questionDTO);
   return "/questionPages/adminlist";
    }

}