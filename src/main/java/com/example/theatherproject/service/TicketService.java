package com.example.theatherproject.service;

import com.example.theatherproject.dto.ClassADTO;
import com.example.theatherproject.dto.TicketDTO;
import com.example.theatherproject.entity.ClassAEntity;
import com.example.theatherproject.entity.MemberEntity;
import com.example.theatherproject.entity.MovieEntity;
import com.example.theatherproject.entity.TicketEntity;
import com.example.theatherproject.repository.ClassARepository;
import com.example.theatherproject.repository.MemberRepository;
import com.example.theatherproject.repository.MovieRepository;
import com.example.theatherproject.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;

    private final MemberRepository memberRepository;

    private final MovieRepository movieRepository;

    private final ClassARepository classARepository;

    public Long save(TicketDTO ticketDTO) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(ticketDTO.getUserId());
        Optional<MovieEntity> optionalMovieEntity = movieRepository.findById(ticketDTO.getSelectId());
        if (optionalMemberEntity.isPresent()) {
            MemberEntity memberEntity = optionalMemberEntity.get();
            if (optionalMovieEntity.isPresent()) {
                MovieEntity movieEntity = optionalMovieEntity.get();

                 Long id= ticketRepository.save(TicketEntity.save(ticketDTO, memberEntity, movieEntity)).getId();

             return id;
            }else{
             return null;
            }

        }return null;
    }

    public TicketDTO findById(Long id) {
        Optional<TicketEntity>optionalTicketEntity= ticketRepository.findById(id);
        if(optionalTicketEntity.isPresent()){
            TicketEntity ticketEntity= optionalTicketEntity.get();
            TicketDTO ticketDTO= TicketDTO.ticketDTO(ticketEntity);
            return ticketDTO;
        }else{
            return null;
        }
    }

    public List<ClassAEntity> check(String ticketDate) {
        List<ClassAEntity> classAEntity = classARepository.findByTicketDate(ticketDate);
        return classAEntity;

    }
}
