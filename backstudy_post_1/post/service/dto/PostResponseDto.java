package com.dsm.post.service.dto;

import com.dsm.post.post.Post;
import lombok.Getter;

@Getter

public class PostResponseDto {
    private Long id;
    private String user;
    private String title;
    private String content;

    public PostResponseDto(Post entity){
        this.id = entity.getId();
        this.user = entity.getUser().getName();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }
}
