package com.example.theatherproject.entity;

import com.example.theatherproject.dto.TicketDTO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Ticket_table")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ticket_Id")
    private Long id;

    @Column
    private int ticketPrice;

    @Column
    private String memberName;

    @Column
    private String movieName;

    @Column
    private String ticketDate;

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

    @OneToMany(mappedBy = "ticketEntity",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<ClassAEntity> classAEntity = new ArrayList<>();

    @OneToMany(mappedBy = "ticketEntity",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<ClassBEntity> classBEntity = new ArrayList<>();

    @OneToMany(mappedBy = "ticketEntity",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<ClassCEntity> classCEntity = new ArrayList<>();

    public static TicketEntity save(TicketDTO ticketDTO,MemberEntity memberEntity, MovieEntity movieEntity) {
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setTicketPrice(ticketDTO.getTicketPrice());
        ticketEntity.setTicketCreated(ticketDTO.getTicketCreated());
        ticketEntity.setTicketDate(ticketDTO.getTicketDate());
        ticketEntity.setMemberName(ticketDTO.getMemberName());
        ticketEntity.setMovieName(ticketDTO.getMovieName());
        ticketEntity.setMovieClass(ticketDTO.getMovieClass());
        ticketEntity.setUserId(ticketDTO.getUserId());
        ticketEntity.setSelectId(ticketDTO.getSelectId());
        ticketEntity.setMemberEntity(memberEntity);
        ticketEntity.setMovieEntity(movieEntity);
        return ticketEntity;
    }
}




