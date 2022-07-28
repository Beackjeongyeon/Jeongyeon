package com.example.theatherproject.controller;

import com.example.theatherproject.dto.BoardDTO;
import com.example.theatherproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    final private BoardService boardService;

    //페이징처리
    @GetMapping("/save-form")
    public String saveForm(){
        return "/BoardPages/BoardSave";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO){
        boardService.save(boardDTO);
        return "redirect:/";

    }@GetMapping("/{id}")
    public String findById(@PathVariable Long id,Model model){
        BoardDTO saveId = boardService.findById(id);
        return "redirect:/";
    }
}
