package com.dsm.post.user;

import com.dsm.post.post.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id", unique = true, nullable = false)
    private long id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    @Size (min = 6, max = 20)
    private String password;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Post.class)
    @JoinColumn(name = "id")
    private Post post;

    @Builder
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
