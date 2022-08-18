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
public class ClassBDTO {

    private Long id;

    private int CountB;

    private int DisCountB;

    private String TicketDate;

    private int B1;

    private int B2;

    private int B3;

    private int B4;

    private int B5;

    private int B6;

    private Long moviePk;

    public ClassBDTO(int countB, int disCountB, String ticketDate, int b1, int b2, int b3, int b4, int b5, int b6, Long moviePk) {
        CountB = countB;
        DisCountB = disCountB;
        TicketDate = ticketDate;
        B1 = b1;
        B2 = b2;
        B3 = b3;
        B4 = b4;
        B5 = b5;
        B6 = b6;
        this.moviePk = moviePk;
    }
}
