package me.kzv.okvue.modules.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "refresh_token")
public class RefreshToken {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "rf_idx")
    private Long idx;

    @Column(name = "rf_email")
    private String email; // account email

    @Column(name = "rf_value")
    private String value;

    public RefreshToken update(String token) {
        this.value = token;
        return this;
    }
}
