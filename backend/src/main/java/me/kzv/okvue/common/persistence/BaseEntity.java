package me.kzv.okvue.common.persistence;

import lombok.Getter;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @Comment("생성일")
    @CreatedDate
    private LocalDateTime createdDate;

    @Comment("수정일")
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Comment("삭제일")
    private LocalDateTime removedDate;

    @Column(columnDefinition = "varchar(255) default 'ACTIVE'")
    @Enumerated(EnumType.STRING)
    private ActiveStatus status;
}
