package com.skysoo.projectlab.dto;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@ToString
@Table(name = "tv_show")
public class TvShow {
    @Id
    @GeneratedValue
    private Integer tvShowCd;
    private String name;

    @OneToOne(mappedBy = "tvShow")
    private Genre genre;

    @OneToMany(mappedBy = "tvShow", fetch = FetchType.LAZY)
    private List<Program> programs = new ArrayList<>();

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setProgram(Program program) {
        this.programs.add(program);
    }

    @Builder
    public TvShow(Integer tvShowCd, String name, Genre genre, List<Program> programs) {
        this.tvShowCd = tvShowCd;
        this.name = name;
        this.genre = genre;
        this.programs = programs;
    }
}
