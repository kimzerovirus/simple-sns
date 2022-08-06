package me.kzv.okvue.infra.common.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
//@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity extends BaseTimeEntity{

//    @CreatedBy
//    @Column(updatable = false)
//    private String createdBy;

//    @LastModifiedBy
//    private String lastModifiedBy;
//    private String lastModifiedBy;

    @Column(columnDefinition = "varchar(255) default 'ACTIVE'")
    @Enumerated(EnumType.STRING)
    private ActiveStatus status;

    protected BaseEntity(){
        status = ActiveStatus.ACTIVE;
    }

    public void updateStatus(ActiveStatus status){
        this.status = status;
    }

}
