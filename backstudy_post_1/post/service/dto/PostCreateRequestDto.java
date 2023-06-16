package com.dsm.post.service.dto;

import com.dsm.post.post.Post;
import com.dsm.post.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostCreateRequestDto {
    private User user;
    private String title;
    private String content;

    @Builder
    public PostCreateRequestDto(User user, String title, String content) {
        this.user = user;
        this.title = title;
        this.content = content;
    }

    public Post toEntity() {
        return Post.builder()
                .user(user)
                .title(title)
                .content(content)
                .build();
    }
}