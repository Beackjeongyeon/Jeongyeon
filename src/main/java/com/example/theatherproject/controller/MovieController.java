package com.example.theatherproject.controller;

import com.example.theatherproject.common.PagingConst;
import com.example.theatherproject.dto.MemberDTO;
import com.example.theatherproject.dto.MovieDTO;
import com.example.theatherproject.service.MemberService;
import com.example.theatherproject.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {
    final private MovieService movieService;

    final private MemberService memberService;

    @GetMapping("/save-form")
    public String saveform() {
        return "moviePages/save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute MovieDTO movieDTO) throws IOException {
        movieService.save(movieDTO);
        return "moviePages/save";
    }
    @GetMapping("/select")
    public String findall( Model model){
        List<MovieDTO> movieDTOList = movieService.findAll();
        model.addAttribute("resultList", movieDTOList);
        System.out.println(movieDTOList);
        return "moviePages/detail";

    }
    @GetMapping
    public String paging(@PageableDefault(page = 1) Pageable pageable, Model model) {
        Page<MovieDTO> movieList = movieService.paging(pageable);
        model.addAttribute("movieList", movieList);
        int startPage = (((int) (Math.ceil((double) pageable.getPageNumber() / PagingConst.BLOCK_LIMIT))) - 1) * PagingConst.BLOCK_LIMIT + 1;
        int endPage = ((startPage + PagingConst.BLOCK_LIMIT - 1) < movieList.getTotalPages()) ? startPage + PagingConst.BLOCK_LIMIT - 1 : movieList.getTotalPages();
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "moviePages/list";
    }
    @GetMapping("/ticket/{id}")
    public String ticket(@PathVariable("id")Long id,HttpSession session, Model model){
        MovieDTO movieDTOList= movieService.findById(id);
        Long result=(Long)session.getAttribute("id");
        MemberDTO memberDTO= memberService.findById(result);
       model.addAttribute("result2", movieDTOList);
       model.addAttribute("movieId", id);
       model.addAttribute("member",memberDTO);
        return "moviePages/ticket";
    }




}
