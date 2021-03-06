package com.jojoldu.bok.springboot.service.posts;


import com.jojoldu.bok.springboot.domain.posts.Posts;
import com.jojoldu.bok.springboot.domain.posts.PostsRepository;
import com.jojoldu.bok.springboot.web.dto.PostsResponseDto;
import com.jojoldu.bok.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.bok.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException(("해당 사용자가 없습니다. id=" + id)));

        return new PostsResponseDto(entity);
    }

}
