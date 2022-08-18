package com.example.theatherproject.dto;

import com.example.theatherproject.entity.MovieEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    private Long id;
    private String movieName;
    private String movieclass;
    private String movieContents;

    private String movieTime;
    private String movieCreated;
    private String movieClose;
    private MultipartFile moviePoster;
    private String moviePosterName;

    public MovieDTO(Long id, String movieName, String movieclass, String movieContents, String movieTime, String movieCreated, String movieClose) {
        this.id = id;
        this.movieName = movieName;
        this.movieclass = movieclass;
        this.movieContents = movieContents;
        this.movieTime = movieTime;
        this.movieCreated = movieCreated;
        this.movieClose = movieClose;
    }

    public static MovieDTO toFind(MovieEntity movieEntity) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movieEntity.getId());
        movieDTO.setMovieName(movieEntity.getMovieName());
        movieDTO.setMovieclass(movieEntity.getMovieclass());
        movieDTO.setMovieContents(movieEntity.getMovieContents());
        movieDTO.setMovieTime(movieEntity.getMovieTime());
        movieDTO.setMovieCreated(movieEntity.getMovieCreated());
        movieDTO.setMovieClose(movieEntity.getMovieClose());
        movieDTO.setMoviePosterName(movieEntity.getMoviePosterName());
        return movieDTO;
    }
}
