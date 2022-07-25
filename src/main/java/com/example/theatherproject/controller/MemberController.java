package com.example.theatherproject.controller;

import com.example.theatherproject.dto.MemberDTO;
import com.example.theatherproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    //회원가입 페이징 처리
    @GetMapping("/Save-form")
    public String saveForm() {

        return "/memberPages/save";
    }

    //회원가입처리
    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        memberService.save(memberDTO);
        return "/index";
    }

    //로그인 페이징 처리
    @GetMapping("/login-form")
    public String loginForm() {

        return "memberPages/login";
    }

    //로그인처리
    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        MemberDTO loginResult = memberService.login(memberDTO);
        if (loginResult != null) {
            session.setAttribute("loginId", loginResult.getMemberId());
            session.setAttribute("id", loginResult.getId());
            return "index";
        } else {
            return "memberPages/login";
        }
    }
    //마이페이지 페이징처리
    @GetMapping("/My-page")
    public String MyPage() {

        return "memberPages/Mypage";
    }
    // 회원정보수정
    @GetMapping("update-form")
    public String update(HttpSession session, Model model) {

        return "memberPages/update";
    }
    // 예약정보확인
    @GetMapping("/confirm-form")
    public String Confirmform(HttpSession session, Model model) {
        return "/memberPages/confirm";
    }
    //나의문의내역
    @GetMapping("/question-form")
    public String questionform(HttpSession session, Model model) {
        return "/memberPages/question";
    }
    //회원 탈퇴
    @GetMapping("/secession-form")
    public String secessionform() {
        return "/memberPages/secession";
    }
    @PostMapping("member/secession")
    public String secession(HttpSession session,String pw){
        String result= (String) session.getAttribute("pw");
        System.out.println(result);
        return "redirect:memberPages/Mypage";
    }
}
