package com.example.theatherproject.entity;

import com.example.theatherproject.dto.TicketDTO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "Ticket_table")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String movieName;

    @Column
    private String movieTime;

    @Column
    private int ticketPrice;

    @Column
    @CreationTimestamp
    private LocalDateTime ticketDate;

    @Column
    private String memberName;

    @Column
    private String memberPhone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_Id")
    private MovieEntity movieEntity;

    public static TicketEntity save(TicketDTO ticketDTO) {
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setMovieName(ticketDTO.getMovieName());
        ticketEntity.setMovieTime(ticketDTO.getMovieTime());
        ticketEntity.setTicketPrice(ticketDTO.getTicketPrice());
        ticketEntity.setTicketDate(ticketDTO.getTicketDate());
        ticketEntity.setMemberName(ticketDTO.getMemberName());
        ticketEntity.setMemberPhone(ticketDTO.getMemberPhone());
        return ticketEntity;
    }
}




