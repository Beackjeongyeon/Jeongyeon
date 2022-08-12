package com.example.theatherproject.entity;

import com.example.theatherproject.dto.MovieDTO;
import com.example.theatherproject.dto.TicketDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
@Table(name = "movie_table")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_Id")
    private Long id;

    @Column
    private String movieName;

    @Column
    private String classA;

    @Column
    private String classB;

    @Column
    private String classC;

    @Column
    private String movieContents;

    @Column
    private String movieCreated;

    @Column
    private LocalDateTime movieOpen;

    @Column
    private LocalDateTime movieClose;

    @Column
    private String movieTime;

    @Column
    private String moviePosterName;

    @Column
    private String movieUrl;

    @OneToMany(mappedBy = "movieEntity",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<ClassAEntity> classAEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "movieEntity",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<ClassBEntity> classBEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "movieEntity",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<ClassBEntity> classCEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "movieEntity",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<TicketEntity> ticketEntityList = new ArrayList<>();

    public static MovieEntity save(MovieDTO movieDTO){
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setMovieName(movieDTO.getMovieName());
        movieEntity.setClassA(movieDTO.getClassA());
        movieEntity.setClassB(movieDTO.getClassB());
        movieEntity.setClassC(movieDTO.getClassC());
        movieEntity.setMovieContents(movieDTO.getMovieContents());
        movieEntity.setMovieCreated(movieDTO.getMovieCreated());
        movieEntity.setMovieOpen(movieDTO.getMovieOpen());
        movieEntity.setMovieClose(movieDTO.getMovieClose());
        movieEntity.setMovieTime(movieDTO.getMovieTime());
        movieEntity.setMoviePosterName(movieDTO.getMoviePosterName());
        movieEntity.setMovieUrl(movieDTO.getMovieUrl());
        return movieEntity;
    }
}
