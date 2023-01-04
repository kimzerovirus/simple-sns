package me.kzv.simpleboard.domain.board;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lme/kzv/simpleboard/domain/board/BoardCustomRepositoryImpl;", "Lme/kzv/simpleboard/domain/board/BoardCustomRepository;", "queryFactory", "Lcom/querydsl/jpa/impl/JPAQueryFactory;", "(Lcom/querydsl/jpa/impl/JPAQueryFactory;)V", "search", "Lme/kzv/simpleboard/domain/PageDto;", "keyword", "", "searchType", "Lme/kzv/simpleboard/domain/board/entity/SearchType;", "pageable", "Lorg/springframework/data/domain/Pageable;", "simpleboard"})
public final class BoardCustomRepositoryImpl implements me.kzv.simpleboard.domain.board.BoardCustomRepository {
    private final com.querydsl.jpa.impl.JPAQueryFactory queryFactory = null;
    
    public BoardCustomRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.querydsl.jpa.impl.JPAQueryFactory queryFactory) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public me.kzv.simpleboard.domain.PageDto search(@org.jetbrains.annotations.Nullable
    java.lang.String keyword, @org.jetbrains.annotations.Nullable
    me.kzv.simpleboard.domain.board.entity.SearchType searchType, @org.jetbrains.annotations.NotNull
    org.springframework.data.domain.Pageable pageable) {
        return null;
    }
}