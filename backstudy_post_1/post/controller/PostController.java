package com.dsm.post.controller;

import com.dsm.post.service.dto.PostCreateRequestDto;
import com.dsm.post.service.dto.PostResponseDto;
import com.dsm.post.service.dto.PostUpdateRequestDto;
import com.dsm.post.post.Post;
import com.dsm.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/post")
@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long creat(@RequestBody PostCreateRequestDto requestDto) {
        return postService.create(requestDto);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto) {
        return postService.update(id, requestDto);
    }

    @GetMapping
    public List<PostResponseDto> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        List<PostResponseDto> responseDtoList = posts.stream()
                .map(PostResponseDto::new)
                .collect(Collectors.toList());
        return responseDtoList;
    }

    @GetMapping("/{id}")
    public PostResponseDto getPostById(@PathVariable Long id) {
        Post post = postService.getPostById(id);
        return new PostResponseDto(post);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        postService.delete(id);
    }
}