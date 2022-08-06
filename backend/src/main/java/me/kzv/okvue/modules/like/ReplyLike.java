package me.kzv.okvue.modules.like;

import lombok.*;
import me.kzv.okvue.modules.reply.Reply;

import javax.persistence.*;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@ToString(exclude = "comment")
public class ReplyLike {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cl_id")
    private Long id;

    @Column(name = "cl_like") // like 는 예약어이므로 테이블 생성시에 에러가 발생한다.
    @Enumerated(EnumType.STRING)
    private LikeType like; // 좋아요는 like: +1, 취소 cancel: 삭제, 싫어요는 dislike: -1

    private Long accountId; // 아이디가 삭제되도 좋아요 수는 변동이 없게 하기 위해 매핑x

    @ManyToOne(fetch = FetchType.LAZY) // 게시글 하나에 좋아요는 여러개
    private Reply comment;

    @Builder
    public ReplyLike(Long id, LikeType like, Long accountId, Reply comment) {
        this.id = id;
        this.like = like;
        this.accountId = accountId;
        this.comment = comment;
    }

    public void updateLikes(LikeType like) {
        this.like = like;
    }

}
