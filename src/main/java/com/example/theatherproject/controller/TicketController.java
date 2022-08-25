package com.example.theatherproject.controller;
import com.example.theatherproject.dto.ClassADTO;
import com.example.theatherproject.dto.TicketDTO;
import com.example.theatherproject.entity.ClassAEntity;
import com.example.theatherproject.entity.TicketEntity;
import com.example.theatherproject.service.MemberService;
import com.example.theatherproject.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/ticket")
public class TicketController {
    private final TicketService ticketService;


    @PostMapping("/save")
    public String save(@ModelAttribute TicketDTO ticketDTO,Model model){
        Long id  = ticketService.save(ticketDTO);
        List<ClassADTO>classADTOList = ticketService.check(ticketDTO.getTicketDate());
        TicketDTO result= ticketService.findById(id);
        model.addAttribute("result",result);
        model.addAttribute("check",classADTOList);
        model.addAttribute("id",id);
        return "ticketPages/select";
    }

}
