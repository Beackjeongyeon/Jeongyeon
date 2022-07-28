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
        return "redirect:/";
    }

    //로그인 페이징 처리
    @GetMapping("/login-form")
    public String loginForm() {

        return "memberPages/login";
    }

    //로그인처리
    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session, Model model) {
        MemberDTO loginResult = memberService.login(memberDTO);
        if (loginResult != null) {
            session.setAttribute("loginId", loginResult.getMemberId());
            session.setAttribute("id", loginResult.getId());
            return "redirect:/";
        } else {
            return "memberPages/login";
        }
    }
    //로그아웃처리
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginId");
        session.removeAttribute("id");
        return "redirect:/";
    }
    //마이페이지 페이징처리
    @GetMapping("/My-page")
    public String MyPage() {

        return "memberPages/Mypage";
    }
    // 회원정보수정
    @GetMapping("update-form")
    public String update() {

        return "memberPages/update";
    }
    // 예약정보확인
    @GetMapping("/confirm-form")
    public String Confirmform() {

        return "/memberPages/confirm";
    }
    //나의문의내역
    @GetMapping("/question-form")
    public String questionform( Model model) {

        return "/memberPages/question";
    }
    //회원 탈퇴
    @GetMapping("/secession-form")
    public String secessionform(HttpSession session, Model model) {
        return "/memberPages/secession";
    }
    @PostMapping("/secession")
    public String secession(HttpSession session,@RequestParam("memberPassword")String pwCheck){
        Long id = (Long)session.getAttribute("id");
        MemberDTO result= memberService.findById(id);
        String pw = result.getMemberPassword();
        System.out.println(pwCheck);
        System.out.println("MemberController.secession");
        System.out.println("session = " + session + ", pwCheck = " + pwCheck);
        if(pw.equals(pwCheck)){
            memberService.delete(id);
            session.invalidate();
            return "redirect:/";
        }else{
            return "redirect:/memberPages/secession";
        }


    }
}
