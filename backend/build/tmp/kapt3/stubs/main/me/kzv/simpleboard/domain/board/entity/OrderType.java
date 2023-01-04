package me.kzv.simpleboard.domain.board.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lme/kzv/simpleboard/domain/board/entity/OrderType;", "", "(Ljava/lang/String;I)V", "value", "Lorg/springframework/data/domain/Sort;", "ASC", "DESC", "simpleboard"})
public enum OrderType {
    /*public static final*/ ASC /* = new @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"}, d2 = {"Lme/kzv/simpleboard/domain/board/entity/OrderType$ASC;", "Lme/kzv/simpleboard/domain/board/entity/OrderType;", "value", "Lorg/springframework/data/domain/Sort;", "simpleboard"}) ASC(){
    
    ASC() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public org.springframework.data.domain.Sort value() {
        return null;
    }
} */,
    /*public static final*/ DESC /* = new @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"}, d2 = {"Lme/kzv/simpleboard/domain/board/entity/OrderType$DESC;", "Lme/kzv/simpleboard/domain/board/entity/OrderType;", "value", "Lorg/springframework/data/domain/Sort;", "simpleboard"}) DESC(){
    
    DESC() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public org.springframework.data.domain.Sort value() {
        return null;
    }
} */;
    
    OrderType() {
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract org.springframework.data.domain.Sort value();
}