package me.kzv.okvue.modules.reply;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.kzv.okvue.modules.account.Account;
import me.kzv.okvue.modules.post.Post;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Reply {

    @Id @GeneratedValue
    @Column(name = "reply_id")
    private Long id;

    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account commenter;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @Builder
    public Reply(Long id, String text, Account commenter, Post post) {
        this.id = id;
        this.text = text;
        this.commenter = commenter;
        this.post = post;
    }
}
