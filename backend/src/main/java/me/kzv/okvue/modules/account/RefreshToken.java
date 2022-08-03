package me.kzv.okvue.modules.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.kzv.okvue.infra.common.entity.BaseTimeEntity;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "refresh_token")
public class RefreshToken extends BaseTimeEntity implements Persistable<String>{

    @Id @Column(name = "rf_account_id")
    private String id; // account id [ email -> id 로 변경 ]

    @Column(name = "rf_value")
    private String value;

    @LastModifiedDate
    private LocalDateTime createdIn;

    public RefreshToken update(String token) {
        this.value = token;
        return this;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        // 새로운 것인지 아닌지를 판별 조건을 작성한다.
        return getCreatedDate() == null;
    }
}
