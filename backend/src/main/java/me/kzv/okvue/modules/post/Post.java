package me.kzv.okvue.modules.post;

import lombok.*;
import me.kzv.okvue.modules.account.Account;
import me.kzv.okvue.infra.common.BaseEntity;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@ToString(exclude = "writer")
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "text", nullable = false)
    private String content;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PostType type;

    // 조회수
    @Column(columnDefinition = "int default 0")
    private int viewCount;

    // 좋아요
    @Column(columnDefinition = "int default 0")
    private int likes;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account writer;

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void updateLikes(int likes) {
        this.likes = likes;
    }
    public void updateViewCount(){
        this.viewCount += 1;
    }
}
