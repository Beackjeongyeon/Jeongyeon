package com.example.theatherproject.entity;

import com.example.theatherproject.dto.ClassBDTO;
import com.example.theatherproject.dto.MovieDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "class_B_table")
public class ClassBEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private int CountB;

    @Column
    private int DisCountB;

    @Column
    private int B1;

    @Column
    private int B2;

    @Column
    private int B3;

    @Column
    private int B4;

    @Column
    private int B5;

    @Column
    private int B6;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_Id")
    private MovieEntity movieEntity;

    public static ClassBEntity save(ClassBDTO classBDTO) {
        ClassBEntity classBEntity = new ClassBEntity();
        classBEntity.setCountB(classBDTO.getCountB());
        classBEntity.setB1(classBDTO.getB1());
        classBEntity.setB2(classBDTO.getB2());
        classBEntity.setB3(classBDTO.getB3());
        classBEntity.setB4(classBDTO.getB4());
        classBEntity.setB5(classBDTO.getB5());
        classBEntity.setB6(classBDTO.getB6());
        return classBEntity;
    }
}
