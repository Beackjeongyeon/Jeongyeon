package com.example.theatherproject.controller;

import com.example.theatherproject.dto.MovieDTO;
import com.example.theatherproject.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {
    final private MovieService movieService;

    @GetMapping("/save-form")
    public String saveform(){
        return "moviePages/save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute MovieDTO movieDTO)throws IOException {
        movieService.save(movieDTO);
        return "moviePages/save";
    }
}
