package com.skysoo.projectlab.dto;

import com.skysoo.projectlab.domain.Author;
import com.skysoo.projectlab.domain.Post;
import lombok.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private long id;
    private String title;
    private String text;
    private String category;
    private Author author;

    public static List<PostDTO> from(Collection<Post> entities) {
        return entities.stream().map(PostDTO::from).collect(Collectors.toList());
    }

    public static PostDTO from(Post entity) {
        return PostDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .text(entity.getText())
                .category(entity.getCategory())
                .author(entity.getAuthor())
                .build();
    }
}
