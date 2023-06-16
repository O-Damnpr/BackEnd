package com.dsm.post.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

//제약조건 걸
@Getter
@NoArgsConstructor

public class PostUpdateRequestDto {

    @NotBlank @Range(min = 1, max = 20)
    private String title;

    @NotBlank @Range(min = 1, max = 1000)
    private String content;

    @Builder
    public PostUpdateRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }
}
