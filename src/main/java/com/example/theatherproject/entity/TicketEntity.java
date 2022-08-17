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
    private String ticketDate;

    @Column
    private String memberName;

    @Column
    private String movieName;

    @Column
    private String movieClass;

    @Column
    private Long userId;
    // 멤버의 pk값
    @Column
    private Long selectId;
    // 영화의 pk값


    @Column
    @CreationTimestamp
    private LocalDateTime ticketCreated;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "member_Id")
   private MemberEntity memberEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_Id")
    private MovieEntity movieEntity;

    public static TicketEntity save(TicketDTO ticketDTO) {
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setTicketTime(ticketDTO.getTicketTime());
        ticketEntity.setTicketPrice(ticketDTO.getTicketPrice());
        ticketEntity.setTicketDate(ticketDTO.getTicketDate());
        ticketEntity.setTicketCreated(ticketDTO.getTicketCreated());
        ticketEntity.setMemberName(ticketDTO.getMemberName());
        ticketEntity.setMovieName(ticketDTO.getMovieName());
        ticketEntity.setMovieClass(ticketDTO.getMovieClass());
        ticketEntity.setUserId(ticketDTO.getUserId());
        ticketEntity.setSelectId(ticketDTO.getSelectId());
        return ticketEntity;
    }
}




