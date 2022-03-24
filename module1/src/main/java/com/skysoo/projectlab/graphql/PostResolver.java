package com.skysoo.projectlab.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.skysoo.projectlab.domain.Author;
import com.skysoo.projectlab.dto.PostDTO;
import com.skysoo.projectlab.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostResolver implements GraphQLResolver<PostDTO> {
    private final AuthorRepository authorRepository;

    public Author getAuthor(PostDTO postResponse) {
        return authorRepository.findById(postResponse.getAuthor().getId()).orElseThrow(NullPointerException::new);
    }
}
