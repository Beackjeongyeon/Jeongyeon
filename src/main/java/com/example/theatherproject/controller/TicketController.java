package com.example.theatherproject.controller;
import com.example.theatherproject.dto.TicketDTO;
import com.example.theatherproject.service.MemberService;
import com.example.theatherproject.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequiredArgsConstructor
@RequestMapping("/ticket")
public class TicketController {
    private final TicketService ticketService;


    @PostMapping("/save")
    public String save(@ModelAttribute TicketDTO ticketDTO,Model model){
        Long id = ticketService.save(ticketDTO);
        TicketDTO result= ticketService.findById(id);
        Long result2 = ticketDTO.getId();
        System.out.println(result);
        System.out.println(result2);
        model.addAttribute("result2",id);
        model.addAttribute("result",result);
        model.addAttribute("id",id);
        return "ticketPages/select";
    }

}
