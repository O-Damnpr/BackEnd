package com.dsm.post.post;

import com.dsm.post.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name="post")

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(length = 30, nullable = false)
    private String title;

    @Column(length = 1000, columnDefinition = "TEXT")
    private String content;

    private String name;
    private String password;

    @Builder
    public Post(User user, String title, String content) {
        this.user = user;
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}