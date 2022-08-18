package com.example.theatherproject.service;

import com.example.theatherproject.dto.ClassADTO;
import com.example.theatherproject.dto.MovieDTO;
import com.example.theatherproject.entity.ClassAEntity;
import com.example.theatherproject.entity.MovieEntity;
import com.example.theatherproject.entity.TicketEntity;
import com.example.theatherproject.repository.ClassARepository;
import com.example.theatherproject.repository.MovieRepository;
import com.example.theatherproject.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassAService {
    private final ClassARepository classARepository;
    private final MovieRepository movieRepository;

    private final TicketRepository ticketRepository;

    public Long save(ClassADTO classADTO) {
        Optional<MovieEntity> optionalMovieEntity = movieRepository.findById(classADTO.getMoviePk());
        if (optionalMovieEntity.isPresent()) {
            MovieEntity movieEntity = optionalMovieEntity.get();
            Optional<TicketEntity>optionalTicketEntity= ticketRepository.findById(classADTO.getTicketPk());
            if(optionalTicketEntity.isPresent()){
               TicketEntity ticketEntity = optionalTicketEntity.get();
            Long id = classARepository.save(ClassAEntity.save(classADTO, movieEntity,ticketEntity)).getId();
            return id;
            }
        } else {
            return null;
        }
        return null;
    }

}
