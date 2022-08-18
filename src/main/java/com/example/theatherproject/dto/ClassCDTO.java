package com.example.theatherproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassCDTO {

    private Long id;

    private int CountC;

    private int DisCountC;

    private String TicketDate;

    private int C1;

    private int C2;

    private int C3;

    private int C4;

    private int C5;

    private int C6;

    private Long moviePk;

    public ClassCDTO(int countC, int disCountC, String ticketDate, int c1, int c2, int c3, int c4, int c5, int c6, Long moviePk) {
        CountC = countC;
        DisCountC = disCountC;
        TicketDate = ticketDate;
        C1 = c1;
        C2 = c2;
        C3 = c3;
        C4 = c4;
        C5 = c5;
        C6 = c6;
        this.moviePk = moviePk;
    }
}
