package me.kzv.simpleboardmvc.web.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;

    private Boolean isActive;

    @ManyToOne
    private Member member;
    @ManyToOne
    private Post post;

    @Builder
    protected Reply(String text, Member member, Post post) {
        this.text = text;
        this.member = member;
        this.post = post;
        this.isActive = true;
    }
}
