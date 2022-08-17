package com.example.theatherproject.service;

import com.example.theatherproject.dto.TicketDTO;
import com.example.theatherproject.entity.TicketEntity;
import com.example.theatherproject.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    public void save(TicketDTO ticketDTO) {
        ticketRepository.save(TicketEntity.save(ticketDTO));

    }
}
