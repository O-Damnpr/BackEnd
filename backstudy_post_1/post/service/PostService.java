package com.dsm.post.service;

import com.dsm.post.service.dto.PostCreateRequestDto;
import com.dsm.post.service.dto.PostUpdateRequestDto;
import com.dsm.post.post.Post;
import com.dsm.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    @Transactional
    public Long create(PostCreateRequestDto requestDto) {
        return postRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDto requestDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("This post does not exist."));
        String name = new String();
        String password = new String();
        if (!post.getName().equals(name) || !post.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid name or password!");
        }
        post.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public void delete(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("This post does not exist!"));
        String name = new String();
        String password = new String();
        if (!post.getName().equals(name) || !post.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid name or password!");
        }
        postRepository.delete(post);
    }

    @Transactional(readOnly = true)
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Post getPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("This post does not exist!"));
    }

}