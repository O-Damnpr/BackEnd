package com.example.back_post.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "Post")

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "post_title")
    @Size(min = 5, max = 300)
    private String title;

    @Column(name = "post_content")
    @Size(max = 5000)
    private String content;

    @Column(name = "post_createDate")
    private LocalDateTime createdDate;


}
