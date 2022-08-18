package com.example.theatherproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassADTO {
    private Long id ;

    private int CountA;

    private int DisCountA;

    private String TicketDate;

    private int A1;

    private int A2;

    private int A3;

    private int A4;

    private int A5;

    private int A6;

    private Long moviePk;

    private Long TicketPk;

    public ClassADTO(int countA, int disCountA, String ticketDate, int a1, int a2, int a3, int a4, int a5, int a6, Long moviePk, Long ticketPk) {
        CountA = countA;
        DisCountA = disCountA;
        TicketDate = ticketDate;
        A1 = a1;
        A2 = a2;
        A3 = a3;
        A4 = a4;
        A5 = a5;
        A6 = a6;
        this.moviePk = moviePk;
        TicketPk = ticketPk;
    }
}
