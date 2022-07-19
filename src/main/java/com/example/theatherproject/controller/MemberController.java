package com.example.theatherproject.controller;
import com.example.theatherproject.dto.MemberDTO;
import com.example.theatherproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/Save-form")
    public String saveForm(){

        return "/memberPages/save";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO){
        memberService.save(memberDTO);
        return "redirect:memberPages/login";
    }
    @GetMapping("/login-form")
    public String loginForm(){
        return "memberPages/login";
    }

}
