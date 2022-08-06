package me.kzv.okvue.modules.post;

import lombok.*;
import me.kzv.okvue.modules.account.Account;
import me.kzv.okvue.infra.common.entity.BaseEntity;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString(exclude = "writer")
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

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

    @Builder
    public Post(Long id, String title, String content, PostType type, Account writer) {
        super();

        this.id = id;
        this.title = title;
        this.content = content;
        this.type = type;
        this.writer = writer;

        // 초기값 설정 table 에서 명시하였지만 여기서도 설정하였다.
        this.viewCount = 0;
        this.likes = 0;
    }

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
