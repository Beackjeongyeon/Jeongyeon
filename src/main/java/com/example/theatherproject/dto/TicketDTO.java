package com.example.theatherproject.dto;

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

    private String movieName;

    private String movieTime;

    private int ticketPrice;

    private LocalDateTime ticketDate;

    private String memberName;

    private String memberPhone;

    public TicketDTO(String movieName, String movieTime, int ticketPrice, LocalDateTime ticketDate, String memberName, String memberPhone) {
        this.movieName = movieName;
        this.movieTime = movieTime;
        this.ticketPrice = ticketPrice;
        this.ticketDate = ticketDate;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
    }
}
