package com.example.theatherproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

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

    private String movieclass;
    private String movieContents;
    private String movieCreated;
    private String movieOpen;
    private String movieClose;
    private MultipartFile moviePoster;
    private String moviePosterName;

    public MovieDTO(String movieName, String movieclass, String movieContents, String movieCreated, String movieOpen, String movieClose, MultipartFile moviePoster, String moviePosterName) {
        this.movieName = movieName;
        this.movieclass = movieclass;
        this.movieContents = movieContents;
        this.movieCreated = movieCreated;
        this.movieOpen = movieOpen;
        this.movieClose = movieClose;
        this.moviePoster = moviePoster;
        this.moviePosterName = moviePosterName;
    }
}
