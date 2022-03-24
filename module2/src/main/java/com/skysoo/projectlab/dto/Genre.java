package com.skysoo.projectlab.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Genre {
    @Id
    @GeneratedValue
    private Integer genreCd;
    private String name;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tvShowCd")
    private TvShow tvShow;

    @Builder
    public Genre(Integer genreCd, String name, TvShow tvShow) {
        this.genreCd = genreCd;
        this.name = name;
        this.tvShow = tvShow;
        tvShow.setGenre(this);
    }
}
