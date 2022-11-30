package me.kzv.simpleboardmvc.web.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reply extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Long id;
    private String text;
    private Boolean isParent; // 부모 댓글인지 아닌지
    private Long groupId; // isParent 가 false 인 경우 자식 댓글이므로 그룹 아이디가 있어야 한다. - nullable 부모 댓글일 경우 null
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Builder
    protected Reply(String text, Member member, Boolean isParent, Post post, Long groupId) {
        this.text = text;
        this.member = member;
        this.isParent = isParent;
        this.post = post;

        this.groupId = groupId;
        this.isActive = true;
    }
}
