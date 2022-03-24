package com.skysoo.projectlab.service;

import com.google.common.collect.Lists;
import com.skysoo.projectlab.dto.Genre;
import com.skysoo.projectlab.dto.Program;
import com.skysoo.projectlab.dto.TvShow;
import com.skysoo.projectlab.repository.GenreRepository;
import com.skysoo.projectlab.repository.ProgramRepository;
import com.skysoo.projectlab.repository.TvShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TvShowService {
    private final TvShowRepository tvShowRepository;
    private final ProgramRepository programRepository;
    private final GenreRepository genreRepository;

    public void saveTvShow() {
        TvShow tvShow = TvShow.builder()
                .name("tvshow")
                .build();

        Genre genre = Genre.builder()
                .name("genre")
                .tvShow(tvShow)
                .build();
        genreRepository.save(genre);

        Program program1 = Program.builder()
                .name("program1")
                .tvShow(tvShow)
                .build();
        Program program2 = Program.builder()
                .name("program2")
                .tvShow(tvShow)
                .build();

        List<Program> programs = Lists.newArrayList(program1, program2);
        programs.stream().forEach(program -> programRepository.save(program));

        TvShow saveTvShow = tvShowRepository.save(tvShow);
        System.out.println(saveTvShow.toString());

    }
}
