package com.skysoo.projectlab.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.skysoo.projectlab.domain.Post;
import com.skysoo.projectlab.dto.PostDTO;
import com.skysoo.projectlab.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional
public class PostQuery implements GraphQLQueryResolver {
    private final PostRepository postRepository;

    public List<PostDTO> getRecentPosts(int count, int offset) {
        final List<Post> all = postRepository.findAll();
        return PostDTO.from(all);
    }
}
