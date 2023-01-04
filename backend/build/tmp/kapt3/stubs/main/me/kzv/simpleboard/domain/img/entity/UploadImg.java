package me.kzv.simpleboard.domain.img.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\'\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lme/kzv/simpleboard/domain/img/entity/UploadImg;", "Lme/kzv/simpleboard/domain/BaseEntity;", "id", "", "imgNm", "", "originImgNm", "imgUrl", "imgType", "Lme/kzv/simpleboard/domain/img/entity/ImgType;", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lme/kzv/simpleboard/domain/img/entity/ImgType;)V", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getImgNm", "()Ljava/lang/String;", "getImgType", "()Lme/kzv/simpleboard/domain/img/entity/ImgType;", "getImgUrl", "getOriginImgNm", "simpleboard"})
@jakarta.persistence.DiscriminatorColumn
@jakarta.persistence.Inheritance(strategy = jakarta.persistence.InheritanceType.SINGLE_TABLE)
@jakarta.persistence.Entity
public abstract class UploadImg extends me.kzv.simpleboard.domain.BaseEntity {
    @org.jetbrains.annotations.Nullable
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id
    private final java.lang.Long id = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String imgNm = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String originImgNm = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String imgUrl = null;
    @org.jetbrains.annotations.NotNull
    @jakarta.persistence.Enumerated(value = jakarta.persistence.EnumType.STRING)
    private final me.kzv.simpleboard.domain.img.entity.ImgType imgType = null;
    
    public UploadImg(@org.jetbrains.annotations.Nullable
    java.lang.Long id, @org.jetbrains.annotations.NotNull
    java.lang.String imgNm, @org.jetbrains.annotations.NotNull
    java.lang.String originImgNm, @org.jetbrains.annotations.NotNull
    java.lang.String imgUrl, @org.jetbrains.annotations.NotNull
    me.kzv.simpleboard.domain.img.entity.ImgType imgType) {
        super(null, null);
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getImgNm() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getOriginImgNm() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getImgUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final me.kzv.simpleboard.domain.img.entity.ImgType getImgType() {
        return null;
    }
}