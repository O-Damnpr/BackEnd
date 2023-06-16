package com.dsm.post.service.dto;

import com.dsm.post.post.Post;
import lombok.Getter;

@Getter

public class PostListResponseDto {
    private Long id;
    private String user;
    private String title;

    public PostListResponseDto(Post entity){
        this.id = entity.getId();
        this.user = entity.getUser().getName();
        this.title = entity.getTitle();
    }
}
