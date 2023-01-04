package me.kzv.simpleboard.domain.reply.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00038\u0006@BX\u0087\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0018"}, d2 = {"Lme/kzv/simpleboard/domain/reply/entity/Reply;", "Lme/kzv/simpleboard/domain/BaseEntity;", "content", "", "board", "Lme/kzv/simpleboard/domain/board/entity/Board;", "replier", "Lme/kzv/simpleboard/domain/member/entity/Member;", "parenId", "", "(Ljava/lang/String;Lme/kzv/simpleboard/domain/board/entity/Board;Lme/kzv/simpleboard/domain/member/entity/Member;Ljava/lang/Long;)V", "getBoard", "()Lme/kzv/simpleboard/domain/board/entity/Board;", "<set-?>", "getContent", "()Ljava/lang/String;", "id", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "parentId", "getParentId", "getReplier", "()Lme/kzv/simpleboard/domain/member/entity/Member;", "simpleboard"})
@jakarta.persistence.Entity
public final class Reply extends me.kzv.simpleboard.domain.BaseEntity {
    @org.jetbrains.annotations.Nullable
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id
    private final java.lang.Long id = null;
    @org.jetbrains.annotations.NotNull
    @jakarta.persistence.Column(nullable = false, columnDefinition = "TEXT")
    private java.lang.String content;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Long parentId = null;
    @org.jetbrains.annotations.NotNull
    @jakarta.persistence.JoinColumn(name = "board_id")
    @jakarta.persistence.ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    private final me.kzv.simpleboard.domain.board.entity.Board board = null;
    @org.jetbrains.annotations.NotNull
    @jakarta.persistence.JoinColumn(name = "member_id")
    @jakarta.persistence.ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    private final me.kzv.simpleboard.domain.member.entity.Member replier = null;
    
    public Reply(@org.jetbrains.annotations.NotNull
    java.lang.String content, @org.jetbrains.annotations.NotNull
    me.kzv.simpleboard.domain.board.entity.Board board, @org.jetbrains.annotations.NotNull
    me.kzv.simpleboard.domain.member.entity.Member replier, @org.jetbrains.annotations.Nullable
    java.lang.Long parenId) {
        super(null, null);
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getContent() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long getParentId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final me.kzv.simpleboard.domain.board.entity.Board getBoard() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final me.kzv.simpleboard.domain.member.entity.Member getReplier() {
        return null;
    }
}