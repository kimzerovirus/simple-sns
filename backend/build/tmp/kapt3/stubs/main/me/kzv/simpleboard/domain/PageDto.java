package me.kzv.simpleboard.domain;

import java.lang.System;

/**
 * Any 는 아무타입이나 사용할 때 * 은 아직 타입이 정해지지 않았지만 한 번 정해지면 계속 그 타입을 유지해야할 경우 사용
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\u0002\u0010\u0004J\r\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u0003H\u00c6\u0003J\u0017\u0010 \u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u00c6\u0001J\u0013\u0010!\u001a\u00020\u00102\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020\nH\u00d6\u0001J\t\u0010$\u001a\u00020%H\u00d6\u0001R\u0015\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\b\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\f\u00a8\u0006&"}, d2 = {"Lme/kzv/simpleboard/domain/PageDto;", "", "page", "Lorg/springframework/data/domain/Page;", "(Lorg/springframework/data/domain/Page;)V", "content", "", "getContent", "()Ljava/util/List;", "cpage", "", "getCpage", "()I", "setCpage", "(I)V", "isNext", "", "()Z", "setNext", "(Z)V", "isPrev", "setPrev", "getPage", "()Lorg/springframework/data/domain/Page;", "pageList", "", "getPageList", "setPageList", "(Ljava/util/List;)V", "totalPage", "getTotalPage", "component1", "copy", "equals", "other", "hashCode", "toString", "", "simpleboard"})
public final class PageDto {
    @org.jetbrains.annotations.NotNull
    private final org.springframework.data.domain.Page<?> page = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<?> content = null;
    private final int totalPage = 0;
    @org.jetbrains.annotations.NotNull
    private java.util.List<java.lang.Integer> pageList;
    private int cpage = 0;
    private boolean isPrev = false;
    private boolean isNext = false;
    
    /**
     * Any 는 아무타입이나 사용할 때 * 은 아직 타입이 정해지지 않았지만 한 번 정해지면 계속 그 타입을 유지해야할 경우 사용
     */
    @org.jetbrains.annotations.NotNull
    public final me.kzv.simpleboard.domain.PageDto copy(@org.jetbrains.annotations.NotNull
    org.springframework.data.domain.Page<?> page) {
        return null;
    }
    
    /**
     * Any 는 아무타입이나 사용할 때 * 은 아직 타입이 정해지지 않았지만 한 번 정해지면 계속 그 타입을 유지해야할 경우 사용
     */
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Any 는 아무타입이나 사용할 때 * 은 아직 타입이 정해지지 않았지만 한 번 정해지면 계속 그 타입을 유지해야할 경우 사용
     */
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    /**
     * Any 는 아무타입이나 사용할 때 * 은 아직 타입이 정해지지 않았지만 한 번 정해지면 계속 그 타입을 유지해야할 경우 사용
     */
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public PageDto(@org.jetbrains.annotations.NotNull
    org.springframework.data.domain.Page<?> page) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final org.springframework.data.domain.Page<?> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final org.springframework.data.domain.Page<?> getPage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<?> getContent() {
        return null;
    }
    
    public final int getTotalPage() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Integer> getPageList() {
        return null;
    }
    
    public final void setPageList(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Integer> p0) {
    }
    
    public final int getCpage() {
        return 0;
    }
    
    public final void setCpage(int p0) {
    }
    
    public final boolean isPrev() {
        return false;
    }
    
    public final void setPrev(boolean p0) {
    }
    
    public final boolean isNext() {
        return false;
    }
    
    public final void setNext(boolean p0) {
    }
}