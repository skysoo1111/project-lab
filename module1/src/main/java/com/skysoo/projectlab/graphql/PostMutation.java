package com.skysoo.projectlab.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.skysoo.projectlab.domain.Post;
import com.skysoo.projectlab.dto.PostDTO;
import com.skysoo.projectlab.repository.AuthorRepository;
import com.skysoo.projectlab.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class PostMutation implements GraphQLMutationResolver {
    private final AuthorRepository authorRepository;
    private final PostRepository postRepository;

    public PostDTO writePost(String title, String text, String category) {
        Post post = Post.builder()
                .id(1)
                .title(title)
                .text(text)
                .category(category)
                .author(authorRepository.getById(1))
                .build();

        final Post save = postRepository.save(post);

        return PostDTO.from(save);
    }
}
