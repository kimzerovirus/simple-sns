package me.kzv.simpleboard.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lme/kzv/simpleboard/domain/BaseEntity;", "Lme/kzv/simpleboard/domain/BaseTimeEntity;", "createdBy", "", "modifiedBy", "(Ljava/lang/String;Ljava/lang/String;)V", "simpleboard"})
public abstract class BaseEntity extends me.kzv.simpleboard.domain.BaseTimeEntity {
    @jakarta.persistence.Column(updatable = false)
    @org.springframework.data.annotation.CreatedBy
    private final java.lang.String createdBy = null;
    @org.springframework.data.annotation.LastModifiedBy
    private final java.lang.String modifiedBy = null;
    
    public BaseEntity() {
        super(null, null);
    }
    
    public BaseEntity(@org.jetbrains.annotations.Nullable
    java.lang.String createdBy, @org.jetbrains.annotations.Nullable
    java.lang.String modifiedBy) {
        super(null, null);
    }
}