package com.example.theatherproject.entity;
import com.example.theatherproject.dto.ClassCDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "class_C_table")
public class ClassCEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private int CountC;

    @Column
    private int DisCountC;

    @Column
    private String TicketDate;

    @Column
    private int C1;

    @Column
    private int C2;

    @Column
    private int C3;

    @Column
    private int C4;

    @Column
    private int C5;

    @Column
    private int C6;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_Id")
    private MovieEntity movieEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_Id")
    private TicketEntity ticketEntity;

    public static ClassCEntity save(ClassCDTO classCDTO,  MovieEntity movieEntity,TicketEntity ticketEntity) {
        ClassCEntity classCEntity = new ClassCEntity();
        classCEntity.setCountC(classCDTO.getCountC());
        classCEntity.setC1(classCDTO.getC1());
        classCEntity.setC2(classCDTO.getC2());
        classCEntity.setC3(classCDTO.getC3());
        classCEntity.setC4(classCDTO.getC4());
        classCEntity.setC5(classCDTO.getC5());
        classCEntity.setC6(classCDTO.getC6());
        classCEntity.setTicketDate(ticketEntity.getTicketDate());
        classCEntity.setMovieEntity(movieEntity);
        return classCEntity;

    }
}