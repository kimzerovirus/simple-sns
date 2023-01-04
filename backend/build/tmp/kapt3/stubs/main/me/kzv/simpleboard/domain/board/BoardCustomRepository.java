package me.kzv.simpleboard.domain.board;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lme/kzv/simpleboard/domain/board/BoardCustomRepository;", "", "search", "Lme/kzv/simpleboard/domain/PageDto;", "keyword", "", "searchType", "Lme/kzv/simpleboard/domain/board/entity/SearchType;", "pageable", "Lorg/springframework/data/domain/Pageable;", "simpleboard"})
public abstract interface BoardCustomRepository {
    
    @org.jetbrains.annotations.NotNull
    public abstract me.kzv.simpleboard.domain.PageDto search(@org.jetbrains.annotations.Nullable
    java.lang.String keyword, @org.jetbrains.annotations.Nullable
    me.kzv.simpleboard.domain.board.entity.SearchType searchType, @org.jetbrains.annotations.NotNull
    org.springframework.data.domain.Pageable pageable);
}