package com.example.backendstudy.domain.board;

import com.example.backendstudy.domain.board.Board;
import com.example.backendstudy.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

public class BoardCreateRequestDto {
    private Member member;
    private String title;
    private String content;

    @Builder
    public BoardCreateRequestDto(Member member, String title, String content){
        this.member = member;
        this.title = title;
        this.content = content;
    }
    public Board toEntity(){
        return Board.builder()
                .member(member)
                .title(title)
                .content(content)
                .build();
    }
}
