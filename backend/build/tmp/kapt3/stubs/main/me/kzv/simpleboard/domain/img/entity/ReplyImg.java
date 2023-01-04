package me.kzv.simpleboard.domain.img.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lme/kzv/simpleboard/domain/img/entity/ReplyImg;", "Lme/kzv/simpleboard/domain/img/entity/UploadImg;", "reply", "Lme/kzv/simpleboard/domain/reply/entity/Reply;", "imgNm", "", "originImgNm", "imgUrl", "(Lme/kzv/simpleboard/domain/reply/entity/Reply;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getReply", "()Lme/kzv/simpleboard/domain/reply/entity/Reply;", "simpleboard"})
@jakarta.persistence.DiscriminatorValue(value = "REPLY")
public final class ReplyImg extends me.kzv.simpleboard.domain.img.entity.UploadImg {
    @org.jetbrains.annotations.NotNull
    @jakarta.persistence.JoinColumn(name = "reply_id")
    @jakarta.persistence.ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    private final me.kzv.simpleboard.domain.reply.entity.Reply reply = null;
    
    public ReplyImg(@org.jetbrains.annotations.NotNull
    me.kzv.simpleboard.domain.reply.entity.Reply reply, @org.jetbrains.annotations.NotNull
    java.lang.String imgNm, @org.jetbrains.annotations.NotNull
    java.lang.String originImgNm, @org.jetbrains.annotations.NotNull
    java.lang.String imgUrl) {
        super(null, null, null, null, null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final me.kzv.simpleboard.domain.reply.entity.Reply getReply() {
        return null;
    }
}