package me.kzv.simpleboardmvc.web.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class PostImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_img_id")
    private Long id;

    private String imgName;
    private String originImgName;
    private String imgUrl;

//    private Boolean isRepImg; // 대표 이미지 여부
//    private Boolean isAttachment; // 첨부 파일 여부

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Builder
    public PostImg(String imgName, String originImgName, String imgUrl, Post post) {
        this.imgName = imgName;
        this.originImgName = originImgName;
        this.imgUrl = imgUrl;
        this.post = post;
    }
}
