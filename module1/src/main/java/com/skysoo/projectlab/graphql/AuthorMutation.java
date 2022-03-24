package com.skysoo.projectlab.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.skysoo.projectlab.domain.Author;
import com.skysoo.projectlab.dto.AuthorDTO;
import com.skysoo.projectlab.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorMutation implements GraphQLMutationResolver {
    private final AuthorRepository authorRepository;

    public AuthorDTO writeAuthor(String name) {
        Author author = Author.builder()
                .name(name)
                .build();
        final Author save = authorRepository.save(author);
        return AuthorDTO.from(save);
    }
}
