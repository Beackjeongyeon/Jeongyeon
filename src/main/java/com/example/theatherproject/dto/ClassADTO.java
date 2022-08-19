package com.example.theatherproject.dto;

import com.example.theatherproject.entity.ClassAEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassADTO {
    private Long id ;

    private int CountA;

    private int DisCountA;

    private String TicketDate;

    private String seat;

    private Long moviePk;

    private Long TicketPk;

    private Long MemberPk;

    public ClassADTO(int countA, int disCountA, String ticketDate, String seat, Long moviePk, Long ticketPk, Long memberPk) {
        CountA = countA;
        DisCountA = disCountA;
        TicketDate = ticketDate;
        this.seat = seat;
        this.moviePk = moviePk;
        TicketPk = ticketPk;
        MemberPk = memberPk;
    }

    public static ClassADTO tofind(ClassAEntity classAEntity) {
        ClassADTO classADTO = new ClassADTO();
        classADTO.setCountA(classAEntity.getCountA());
        classADTO.setDisCountA(classAEntity.getDisCountA());
        classADTO.setTicketDate(classAEntity.getTicketDate());
        classADTO.setSeat(classAEntity.getSeat());
        classADTO.setMoviePk(classAEntity.getMoviePk());
        classADTO.setTicketPk(classAEntity.getTicketPk());
        classADTO.setMemberPk(classAEntity.getMemberPk());
        return classADTO;
    }


}
