package me.kzv.simpleboard.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lme/kzv/simpleboard/domain/BaseTimeEntity;", "", "createdAt", "Ljava/time/LocalDateTime;", "modifiedAt", "(Ljava/time/LocalDateTime;Ljava/time/LocalDateTime;)V", "simpleboard"})
public abstract class BaseTimeEntity {
    @jakarta.persistence.Column(updatable = false)
    @org.springframework.data.annotation.CreatedDate
    private final java.time.LocalDateTime createdAt = null;
    @org.springframework.data.annotation.LastModifiedDate
    private final java.time.LocalDateTime modifiedAt = null;
    
    public BaseTimeEntity() {
        super();
    }
    
    public BaseTimeEntity(@org.jetbrains.annotations.Nullable
    java.time.LocalDateTime createdAt, @org.jetbrains.annotations.Nullable
    java.time.LocalDateTime modifiedAt) {
        super();
    }
}