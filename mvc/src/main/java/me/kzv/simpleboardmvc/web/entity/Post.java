package me.kzv.simpleboardmvc.web.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @Lob private String content;

    private Boolean isActive;

    @ManyToOne private Member member;
    @OneToMany private List<Reply> replyList = new ArrayList<>();

    @Builder
    public Post(String title, String content, Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
        this.isActive = true;
    }
}
