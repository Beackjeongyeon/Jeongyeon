package com.example.theatherproject.service;

import com.example.theatherproject.dto.MovieDTO;
import com.example.theatherproject.entity.MovieEntity;
import com.example.theatherproject.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class MovieService {
    final private MovieRepository movieRepository;
    public Long save(MovieDTO movieDTO)throws IOException {
        MultipartFile File= movieDTO.getMoviePoster();
        String FileName= File.getOriginalFilename();
        FileName = System.currentTimeMillis() +"_" + FileName;
        String savePath = "D:\\movie_img\\"+ FileName;
        if(!File.isEmpty()){
            File.transferTo(new File(savePath));
        }
        movieDTO.setMoviePosterName(FileName);
        MovieEntity movieEntity = MovieEntity.save(movieDTO);
        return movieRepository.save(movieEntity).getId();

        }
    }

