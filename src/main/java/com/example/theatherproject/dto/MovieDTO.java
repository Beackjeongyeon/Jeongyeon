package com.example.theatherproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    private Long id;
    private String movieName;
    private String classA;
    private String classB;
    private String classC;
    private String movieContents;
    private String movieCreated;
    private LocalDateTime movieOpen;
    private LocalDateTime movieClose;
    private String movieTime;
    private String moviePosterName;
    private String movieUrl;

    public MovieDTO(String movieName, String classA, String classB, String classC, String movieContents, String movieCreated, LocalDateTime movieOpen, LocalDateTime movieClose, String movieTime, String moviePosterName, String movieUrl) {
        this.movieName = movieName;
        this.classA = classA;
        this.classB = classB;
        this.classC = classC;
        this.movieContents = movieContents;
        this.movieCreated = movieCreated;
        this.movieOpen = movieOpen;
        this.movieClose = movieClose;
        this.movieTime = movieTime;
        this.moviePosterName = moviePosterName;
        this.movieUrl = movieUrl;
    }

}
