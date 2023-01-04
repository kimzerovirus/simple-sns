package me.kzv.simpleboard.domain.member.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0003R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00038\u0006@BX\u0087\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\tR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00138\u0006@BX\u0087\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lme/kzv/simpleboard/domain/member/entity/Member;", "Lme/kzv/simpleboard/domain/BaseEntity;", "email", "", "nickname", "socialType", "Lme/kzv/simpleboard/domain/member/entity/SocialType;", "(Ljava/lang/String;Ljava/lang/String;Lme/kzv/simpleboard/domain/member/entity/SocialType;)V", "getEmail", "()Ljava/lang/String;", "id", "", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "<set-?>", "getNickname", "profileUrl", "getProfileUrl", "Lme/kzv/simpleboard/domain/member/entity/Role;", "role", "getRole", "()Lme/kzv/simpleboard/domain/member/entity/Role;", "getSocialType", "()Lme/kzv/simpleboard/domain/member/entity/SocialType;", "updateNickname", "", "updateProfileUrl", "simpleboard"})
@jakarta.persistence.Entity
public final class Member extends me.kzv.simpleboard.domain.BaseEntity {
    @org.jetbrains.annotations.Nullable
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id
    private final java.lang.Long id = null;
    @org.jetbrains.annotations.NotNull
    @jakarta.persistence.Column(nullable = false)
    private final java.lang.String email = null;
    @org.jetbrains.annotations.NotNull
    @jakarta.persistence.Column(nullable = false)
    private java.lang.String nickname;
    @org.jetbrains.annotations.Nullable
    private java.lang.String profileUrl;
    @org.jetbrains.annotations.NotNull
    @jakarta.persistence.Enumerated(value = jakarta.persistence.EnumType.STRING)
    private me.kzv.simpleboard.domain.member.entity.Role role = me.kzv.simpleboard.domain.member.entity.Role.USER;
    @org.jetbrains.annotations.NotNull
    @jakarta.persistence.Enumerated(value = jakarta.persistence.EnumType.STRING)
    private final me.kzv.simpleboard.domain.member.entity.SocialType socialType = null;
    
    public Member(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String nickname, @org.jetbrains.annotations.NotNull
    me.kzv.simpleboard.domain.member.entity.SocialType socialType) {
        super(null, null);
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNickname() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getProfileUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final me.kzv.simpleboard.domain.member.entity.Role getRole() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final me.kzv.simpleboard.domain.member.entity.SocialType getSocialType() {
        return null;
    }
    
    public final void updateNickname(@org.jetbrains.annotations.NotNull
    java.lang.String nickname) {
    }
    
    public final void updateProfileUrl(@org.jetbrains.annotations.NotNull
    java.lang.String profileUrl) {
    }
}