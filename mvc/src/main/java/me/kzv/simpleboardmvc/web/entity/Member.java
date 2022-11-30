package me.kzv.simpleboardmvc.web.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.kzv.simpleboardmvc.web.entity.enums.SocialType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email;
    private String password;
    private String nickname;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private Boolean isActive;

    @OneToMany(mappedBy = "member")
    private List<Post> postList = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<Reply> replyList = new ArrayList<>();

    @Builder
    protected Member(String email, String password, String nickname, SocialType socialType) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.socialType = socialType;
        this.isActive = true;
    }
}
