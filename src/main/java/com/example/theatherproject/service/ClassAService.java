package com.example.theatherproject.service;

import com.example.theatherproject.dto.ClassADTO;
import com.example.theatherproject.dto.MovieDTO;
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
public class ClassAService {
    private final ClassARepository classARepository;
    private final MovieRepository movieRepository;

    private final TicketRepository ticketRepository;

    private final MemberRepository memberRepository;

    public Long save(ClassADTO classADTO) {
        Optional<MovieEntity> optionalMovieEntity = movieRepository.findById(classADTO.getMoviePk());
        if (optionalMovieEntity.isPresent()) {
            MovieEntity movieEntity = optionalMovieEntity.get();
            Optional<TicketEntity> optionalTicketEntity = ticketRepository.findById(classADTO.getTicketPk());
            if (optionalTicketEntity.isPresent()) {
                TicketEntity ticketEntity = optionalTicketEntity.get();
                Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(ticketEntity.getUserId());
                if (optionalMemberEntity.isPresent()) {
                    MemberEntity memberEntity = optionalMemberEntity.get();
                    Long id = classARepository.save(ClassAEntity.save(classADTO, movieEntity, ticketEntity, memberEntity)).getId();
                    return id;
                }
            } else {
                return null;
            }
            return null;
        }

        return null;
    }

    public ClassADTO findById(Long id) {
        Optional<ClassAEntity>optionalClassAEntity = classARepository.findById(id);
        if(optionalClassAEntity.isPresent()){
            ClassAEntity classAEntity= optionalClassAEntity.get();
            ClassADTO classADTO = ClassADTO.tofind(classAEntity);
            return classADTO;
        }else{
            return null;
        }
    }


}
