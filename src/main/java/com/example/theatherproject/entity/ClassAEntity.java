package com.example.theatherproject.entity;

import com.example.theatherproject.dto.ClassADTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
@Table(name = "class_A_table")
public class ClassAEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private int CountA;

    @Column
    private int DisCountA;

    @Column
    private int A1;

    @Column
    private int A2;

    @Column
    private int A3;

    @Column
    private int A4;

    @Column
    private int A5;

    @Column
    private int A6;

    @Column
    private Long movieId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_Id")
    private MovieEntity movieEntity;


    public static ClassAEntity save(ClassADTO classADTO) {
        ClassAEntity classAEntity = new ClassAEntity();
        classAEntity.setCountA(classADTO.getCountA());
        classAEntity.setA1(classADTO.getA1());
        classAEntity.setA2(classADTO.getA2());
        classAEntity.setA3(classADTO.getA3());
        classAEntity.setA4(classADTO.getA4());
        classAEntity.setA5(classADTO.getA5());
        classAEntity.setA6(classADTO.getA6());
        classAEntity.setMovieId(classADTO.getMovieId());
        return classAEntity;
    }
}
