package com.example.theatherproject.service;

import com.example.theatherproject.common.PagingConst;
import com.example.theatherproject.dto.MovieDTO;
import com.example.theatherproject.entity.MovieEntity;
import com.example.theatherproject.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    final private MovieRepository movieRepository;
    public Long save(MovieDTO movieDTO)throws IOException {
        MultipartFile File= movieDTO.getMoviePoster();
        String FileName= File.getOriginalFilename();
        FileName = System.currentTimeMillis() +"_" + FileName;
        String savePath = "D:\\springboot_img\\"+ FileName;
        if(!File.isEmpty()){
            File.transferTo(new File(savePath));
        }
        movieDTO.setMoviePosterName(FileName);
        MovieEntity movieEntity = MovieEntity.save(movieDTO);
        return movieRepository.save(movieEntity).getId();

        }

    public List<MovieDTO> findAll() {
        List<MovieEntity> movieEntityList = movieRepository.findAll();
        List<MovieDTO>movieDTOList = new ArrayList<>();
        for(MovieEntity movieEntity: movieEntityList){
            movieDTOList.add(MovieDTO.toFind(movieEntity));
        }
        return movieDTOList;
    }

    public Page<MovieDTO> paging(Pageable pageable) {
        int page = pageable.getPageNumber(); // 요청 페이지값 가져옴.
        // 요청한 페이지가 1이면 페이지값을 0으로 하고 1이 아니면 요청 페이지에서 1을 뺀다.
//        page = page - 1;
        // 삼항연산자
        page = (page == 1)? 0: (page-1);
        Page<MovieEntity> movieEntities =
                movieRepository.findAll(PageRequest.of(page, PagingConst.PAGE_LIMIT, Sort.by(Sort.Direction.DESC, "id")));
        // Page<BoardEntity> => Page<BoardDTO>
        Page<MovieDTO> movieList = movieEntities.map(
                // BoardEntity 객체 -> BoardDTO 객체 변환
                // board: BoardEntity 객체
                // new BoardDTO() 생성자
                movie -> new MovieDTO(movie.getId(),
                        movie.getMovieName(),
                        movie.getMovieclass(),
                        movie.getMovieContents(),
                        movie.getMovieCreated(),
                        movie.getMovieOpen(),
                        movie.getMovieClose()

                ));
        return movieList;
    }

    @Transactional
    public List<MovieDTO> findById(Long id) {
        List<MovieEntity> movieEntityList= movieRepository.findAll();
        List<MovieDTO> movieDTOList = new ArrayList<>();
        for(MovieEntity movieEntity: movieEntityList){
            movieDTOList.add(MovieDTO.toFind(movieEntity));
        }
        return movieDTOList;

    }
}

