package com.example.theatherproject.dto;

import com.example.theatherproject.entity.MemberEntity;
import com.example.theatherproject.entity.TicketEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {

    private Long id;

    private int ticketPrice;

    private String ticketDate;

    private LocalDateTime ticketCreated;

    private String memberName;

    private String movieName;

    private String movieClass;

    private Long userId;

    private Long selectId;


    public TicketDTO(int ticketPrice, String ticketDate, LocalDateTime ticketCreated, String memberName, String movieName, String movieClass, Long userId, Long selectId) {
        this.ticketPrice = ticketPrice;
        this.ticketDate = ticketDate;
        this.ticketCreated = ticketCreated;
        this.memberName = memberName;
        this.movieName = movieName;
        this.movieClass = movieClass;
        this.userId = userId;
        this.selectId = selectId;
    }

    public static TicketDTO ticketDTO(TicketEntity ticketEntity) {
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setMemberName(ticketEntity.getMemberName());
        ticketDTO.setMovieName(ticketEntity.getMovieName());
        ticketDTO.setMovieClass(ticketEntity.getMovieClass());
        ticketDTO.setTicketPrice(ticketEntity.getTicketPrice());
        ticketDTO.setTicketDate(ticketEntity.getTicketDate());
        ticketDTO.setTicketCreated(ticketEntity.getTicketCreated());
        ticketDTO.setUserId(ticketEntity.getUserId());
        ticketDTO.setSelectId(ticketEntity.getSelectId());
        return ticketDTO;
    }
}
