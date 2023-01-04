package me.kzv.simpleboard.domain.board.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003R \u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038\u0006@BX\u0087\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR \u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038\u0006@BX\u0087\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lme/kzv/simpleboard/domain/board/entity/Board;", "Lme/kzv/simpleboard/domain/BaseEntity;", "title", "", "content", "writer", "Lme/kzv/simpleboard/domain/member/entity/Member;", "(Ljava/lang/String;Ljava/lang/String;Lme/kzv/simpleboard/domain/member/entity/Member;)V", "<set-?>", "getContent", "()Ljava/lang/String;", "id", "", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTitle", "getWriter", "()Lme/kzv/simpleboard/domain/member/entity/Member;", "update", "", "simpleboard"})
@jakarta.persistence.Entity
public final class Board extends me.kzv.simpleboard.domain.BaseEntity {
    @org.jetbrains.annotations.Nullable
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id
    private final java.lang.Long id = null;
    @org.jetbrains.annotations.NotNull
    @jakarta.persistence.Column(nullable = false)
    private java.lang.String title;
    @org.jetbrains.annotations.NotNull
    @jakarta.persistence.Column(nullable = false, columnDefinition = "TEXT")
    private java.lang.String content;
    @org.jetbrains.annotations.NotNull
    @jakarta.persistence.JoinColumn(name = "member_id")
    @jakarta.persistence.ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    private final me.kzv.simpleboard.domain.member.entity.Member writer = null;
    
    public Board(@org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    java.lang.String content, @org.jetbrains.annotations.NotNull
    me.kzv.simpleboard.domain.member.entity.Member writer) {
        super(null, null);
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getContent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final me.kzv.simpleboard.domain.member.entity.Member getWriter() {
        return null;
    }
    
    public final void update(@org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    java.lang.String content) {
    }
}