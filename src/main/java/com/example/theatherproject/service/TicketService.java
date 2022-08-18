package com.example.theatherproject.service;

import com.example.theatherproject.dto.TicketDTO;
import com.example.theatherproject.entity.MemberEntity;
import com.example.theatherproject.entity.MovieEntity;
import com.example.theatherproject.entity.TicketEntity;
import com.example.theatherproject.repository.MemberRepository;
import com.example.theatherproject.repository.MovieRepository;
import com.example.theatherproject.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;

    private final MemberRepository memberRepository;

    private final MovieRepository movieRepository;

    public TicketDTO save(TicketDTO ticketDTO) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(ticketDTO.getUserId());
        Optional<MovieEntity> optionalMovieEntity = movieRepository.findById(ticketDTO.getSelectId());
        if (optionalMemberEntity.isPresent()) {
            MemberEntity memberEntity = optionalMemberEntity.get();
            if (optionalMovieEntity.isPresent()) {
                MovieEntity movieEntity = optionalMovieEntity.get();
             TicketEntity ticketEntity= ticketRepository.save(TicketEntity.save(ticketDTO, memberEntity, movieEntity));
             TicketDTO ticketDTO1= TicketDTO.ticketDTO(ticketEntity);
             return ticketDTO1;
            }else{
             return null;
            }

        }return null;
    }
}
