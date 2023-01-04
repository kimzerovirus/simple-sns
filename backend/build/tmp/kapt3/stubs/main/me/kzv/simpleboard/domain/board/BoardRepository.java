package me.kzv.simpleboard.domain.board;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000f"}, d2 = {"Lme/kzv/simpleboard/domain/board/BoardRepository;", "Lorg/springframework/data/jpa/repository/JpaRepository;", "Lme/kzv/simpleboard/domain/board/entity/Board;", "", "Lme/kzv/simpleboard/domain/board/BoardCustomRepository;", "findByContentContaining", "Lorg/springframework/data/domain/Page;", "content", "", "pageable", "Lorg/springframework/data/domain/Pageable;", "findByTitleContaining", "title", "findByWriter_NicknameContaining", "nickname", "simpleboard"})
public abstract interface BoardRepository extends org.springframework.data.jpa.repository.JpaRepository<me.kzv.simpleboard.domain.board.entity.Board, java.lang.Long>, me.kzv.simpleboard.domain.board.BoardCustomRepository {
    
    @org.jetbrains.annotations.NotNull
    public abstract org.springframework.data.domain.Page<me.kzv.simpleboard.domain.board.entity.Board> findByTitleContaining(@org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    org.springframework.data.domain.Pageable pageable);
    
    @org.jetbrains.annotations.NotNull
    public abstract org.springframework.data.domain.Page<me.kzv.simpleboard.domain.board.entity.Board> findByWriter_NicknameContaining(@org.jetbrains.annotations.NotNull
    java.lang.String nickname, @org.jetbrains.annotations.NotNull
    org.springframework.data.domain.Pageable pageable);
    
    @org.jetbrains.annotations.NotNull
    public abstract org.springframework.data.domain.Page<me.kzv.simpleboard.domain.board.entity.Board> findByContentContaining(@org.jetbrains.annotations.NotNull
    java.lang.String content, @org.jetbrains.annotations.NotNull
    org.springframework.data.domain.Pageable pageable);
}