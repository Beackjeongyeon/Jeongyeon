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
    private String ticketTime;

    @Column
    private int ticketPrice;

    @Column
    @CreationTimestamp
    private LocalDateTime ticketDate;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "member_Id")
   private MemberEntity memberEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_Id")
    private MovieEntity movieEntity;

    public static TicketEntity save(TicketDTO ticketDTO,MemberEntity memberEntity,MovieEntity movieEntity) {
        TicketEntity ticketEntity = new TicketEntity();
        memberEntity.setMemberName(memberEntity.getMemberName());
        ticketEntity.setTicketTime(ticketDTO.getTicketTime());
        ticketEntity.setTicketPrice(ticketDTO.getTicketPrice());
        ticketEntity.setTicketDate(ticketDTO.getTicketDate());
        movieEntity.setMovieName(movieEntity.getMovieName());
        movieEntity.setMovieclass(movieEntity.getMovieclass());
        return ticketEntity;
    }
}




