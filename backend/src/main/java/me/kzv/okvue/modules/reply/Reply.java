package me.kzv.okvue.modules.reply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.kzv.okvue.modules.account.Account;
import me.kzv.okvue.modules.post.Post;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
}
