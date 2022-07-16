package me.kzv.okvue.web.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RefreshToken {

    @Id
    private String email; // account email

    private String value;

    public RefreshToken update(String token) {
        this.value = token;
        return this;
    }
}
