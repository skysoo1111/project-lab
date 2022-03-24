package com.skysoo.projectlab.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Program {
    @Id
    @GeneratedValue
    private Integer programCd;
    private String name;

    // 연관 관계 주인
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tvShowCd") // 외래키 매핑
    private TvShow tvShow;

    @Builder
    public Program(Integer programCd, String name, TvShow tvShow) {
        this.programCd = programCd;
        this.name = name;
        this.tvShow = tvShow;
        tvShow.setProgram(this);
    }
}
