package com.example.theatherproject.service;

import com.example.theatherproject.dto.TicketDTO;
import com.example.theatherproject.entity.TicketEntity;
import com.example.theatherproject.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketDTO save(TicketDTO ticketDTO) {
        TicketEntity ticketEntity = ticketRepository.save(TicketEntity.save(ticketDTO));
        TicketDTO ticketDTO1 = TicketDTO.ticketDTO(ticketEntity);
        if (ticketDTO1 != null) {
            return ticketDTO1;
        } else {
            return null;
        }
    }
}

