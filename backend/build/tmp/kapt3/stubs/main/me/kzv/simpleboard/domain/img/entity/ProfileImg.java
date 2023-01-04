package me.kzv.simpleboard.domain.img.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lme/kzv/simpleboard/domain/img/entity/ProfileImg;", "Lme/kzv/simpleboard/domain/img/entity/UploadImg;", "member", "Lme/kzv/simpleboard/domain/member/entity/Member;", "imgNm", "", "originImgNm", "imgUrl", "(Lme/kzv/simpleboard/domain/member/entity/Member;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMember", "()Lme/kzv/simpleboard/domain/member/entity/Member;", "simpleboard"})
@jakarta.persistence.DiscriminatorValue(value = "Profile")
public final class ProfileImg extends me.kzv.simpleboard.domain.img.entity.UploadImg {
    @org.jetbrains.annotations.NotNull
    @jakarta.persistence.JoinColumn(name = "member_id")
    @jakarta.persistence.ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    private final me.kzv.simpleboard.domain.member.entity.Member member = null;
    
    public ProfileImg(@org.jetbrains.annotations.NotNull
    me.kzv.simpleboard.domain.member.entity.Member member, @org.jetbrains.annotations.NotNull
    java.lang.String imgNm, @org.jetbrains.annotations.NotNull
    java.lang.String originImgNm, @org.jetbrains.annotations.NotNull
    java.lang.String imgUrl) {
        super(null, null, null, null, null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final me.kzv.simpleboard.domain.member.entity.Member getMember() {
        return null;
    }
}