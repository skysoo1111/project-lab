package com.study.javabasic.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EpisodeDTO {
    private List<ImageDTO> stream_meta;
}
