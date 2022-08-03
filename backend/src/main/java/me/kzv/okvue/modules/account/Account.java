package me.kzv.okvue.modules.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.kzv.okvue.infra.common.entity.BaseEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String nickname;

    private String password;

    private String profileImage;

    @Column(columnDefinition = "boolean default false")
    private boolean emailVerified;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Authority authority;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LoginType loginType;

    @Builder
    public Account(Long id, String email, String nickname, String password, String profileImage, LoginType loginType) {
        super();

        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.profileImage = profileImage;
        this.loginType = loginType;

        this.emailVerified = false;
        this.authority = Authority.GUEST; // TODO 처음 계정을 설정하면 GUEST 이지만 이메일 인증을 하면 USER 로 승격
    }

    public Account updateProfile(String profileImage) {
        this.profileImage = profileImage;
        return this;
    }

    public Account updateVerifiedEmailAccount() {
        this.emailVerified = true;
        this.authority = Authority.USER;
        return this;
    }

    public String getAuthority(){
        return this.authority.getKey();
    }
}
