package com.example.backendstudy.domain.member; //이 클래스가 속하는 패키지를 선언한다.

import com.example.backendstudy.domain.board.Board; //Member 클래스에서 Board 클래스를 사용하기 위해 import 한다.
import jakarta.persistence.*; //JPAAPI를 import 해온다.
import lombok.Builder; //Builder 어노테이션을 import 한다
import lombok.Getter; //Getter 어노테이션을 import 한다.
import lombok.NoArgsConstructor; //NoArgsConstructor 어노테이션을 import 한다.

import java.util.ArrayList;
import java.util.List;

@Getter //자동으로 필드에 Getter 메서드를 생성해준다.
@NoArgsConstructor //인자가 없는 생성자를 생성해준다.
@Entity //해당 클래스를 JPA Entity로 지정한다.
@Table(name = "member") //이 클래스를 member라는 이름을 가진 데이터베이스와 매핑한다.
public class Member { //Member 클래스를 선언한다.
    //필드
    @Id //Entity의 primary key를 나타낸다.
    @GeneratedValue //primary key의 생성 규칙을 표시해준다.
    @Column(name = "member_id", unique = true, nullable = false) //
    private long id;

    @Column(length = 15, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 20, nullable = false)
    private String contact;

    @OneToMany(mappedBy = "member", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<Board> board = new ArrayList<>();

    @Builder

    public Member(String name, String password, String email, String contact) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.contact = contact;
    }
}
