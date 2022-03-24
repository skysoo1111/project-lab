package com.skysoo.projectlab.dto;

import com.skysoo.projectlab.domain.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class AuthorDTO {
    private int id;
    private String name;

    public static List<AuthorDTO> from(Collection<Author> authorList) {
        return authorList.stream().map(AuthorDTO::from).collect(Collectors.toList());
    }

    public static AuthorDTO from(Author authorEntity) {
        return AuthorDTO.builder()
                .id(authorEntity.getId())
                .name(authorEntity.getName())
                .build();
    }
}
