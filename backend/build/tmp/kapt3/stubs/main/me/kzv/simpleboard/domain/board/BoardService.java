package me.kzv.simpleboard.domain.board;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ$\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J$\u0010\u0011\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0017J \u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\fH\u0017J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lme/kzv/simpleboard/domain/board/BoardService;", "", "boardRepository", "Lme/kzv/simpleboard/domain/board/BoardRepository;", "memberRepository", "Lme/kzv/simpleboard/domain/member/MemberRepository;", "replyRepository", "Lme/kzv/simpleboard/domain/reply/ReplyRepository;", "(Lme/kzv/simpleboard/domain/board/BoardRepository;Lme/kzv/simpleboard/domain/member/MemberRepository;Lme/kzv/simpleboard/domain/reply/ReplyRepository;)V", "getList", "Lme/kzv/simpleboard/domain/PageDto;", "keyword", "", "searchType", "Lme/kzv/simpleboard/domain/board/entity/SearchType;", "pageable", "Lorg/springframework/data/domain/Pageable;", "getListWithReplyCount", "getWithReplies", "", "boardId", "", "modify", "board", "Lme/kzv/simpleboard/domain/board/entity/Board;", "register", "memberId", "title", "content", "removeWithReplies", "simpleboard"})
@org.springframework.stereotype.Service
@org.springframework.transaction.annotation.Transactional(readOnly = true)
public class BoardService {
    private final me.kzv.simpleboard.domain.board.BoardRepository boardRepository = null;
    private final me.kzv.simpleboard.domain.member.MemberRepository memberRepository = null;
    private final me.kzv.simpleboard.domain.reply.ReplyRepository replyRepository = null;
    
    public BoardService(@org.jetbrains.annotations.NotNull
    me.kzv.simpleboard.domain.board.BoardRepository boardRepository, @org.jetbrains.annotations.NotNull
    me.kzv.simpleboard.domain.member.MemberRepository memberRepository, @org.jetbrains.annotations.NotNull
    me.kzv.simpleboard.domain.reply.ReplyRepository replyRepository) {
        super();
    }
    
    @org.springframework.transaction.annotation.Transactional
    public long register(long memberId, @org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    java.lang.String content) {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public me.kzv.simpleboard.domain.PageDto getList(@org.jetbrains.annotations.NotNull
    java.lang.String keyword, @org.jetbrains.annotations.Nullable
    me.kzv.simpleboard.domain.board.entity.SearchType searchType, @org.jetbrains.annotations.NotNull
    org.springframework.data.domain.Pageable pageable) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public me.kzv.simpleboard.domain.PageDto getListWithReplyCount(@org.jetbrains.annotations.Nullable
    java.lang.String keyword, @org.jetbrains.annotations.Nullable
    me.kzv.simpleboard.domain.board.entity.SearchType searchType, @org.jetbrains.annotations.NotNull
    org.springframework.data.domain.Pageable pageable) {
        return null;
    }
    
    public void getWithReplies(long boardId) {
    }
    
    @org.springframework.transaction.annotation.Transactional
    public void removeWithReplies(long boardId) {
    }
    
    @org.springframework.transaction.annotation.Transactional
    public void modify(@org.jetbrains.annotations.NotNull
    me.kzv.simpleboard.domain.board.entity.Board board) {
    }
}