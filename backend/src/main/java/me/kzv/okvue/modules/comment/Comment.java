package me.kzv.okvue.modules.comment;

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
public class Comment {

    @Id @GeneratedValue
    private Long idx;

    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account commenter;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;
}
