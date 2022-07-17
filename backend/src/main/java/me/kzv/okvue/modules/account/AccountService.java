package me.kzv.okvue.modules.account;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import me.kzv.okvue.infra.security.jwt.JwtTokenProvider;
import me.kzv.okvue.modules.account.dto.LoginRequestDto;
import me.kzv.okvue.modules.account.dto.SignupRequestDto;
import me.kzv.okvue.modules.account.dto.TokenDto;
import me.kzv.okvue.modules.account.dto.TokenRequestDto;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public Account signupWithLocalPlatform(SignupRequestDto dto){
        Account account = dto.toAccount(passwordEncoder);

        return accountRepository.save(account);
    }

    @Transactional
    public TokenDto login(LoginRequestDto dto) {
        log.info("=================로그인=================");

        // 1. 로그인 ID/PW 를 기반으로 AuthenticationToken 생성
        UsernamePasswordAuthenticationToken authenticationToken = dto.toAuthentication();
        log.info(authenticationToken);
        // 2. 검증 (사용자 비밀번호 체크)
        // authenticate 메소드가 실행 될 때 CustomUserDetailsService 에서 만들었던 loadUserByUsername 메소드가 실행됨
        // AbstractUserDetailsAuthenticationProvider 에서 검증
        // 인증 과정에서 role 이 없거나 비밀번호가 틀린 경우
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 jwt 토큰 생성
        TokenDto token = tokenProvider.create(authentication);

        // 4. RefreshToken 저장
        RefreshToken refreshToken = RefreshToken.builder()
                .email(authentication.getName())
                .value(token.getRefreshToken())
                .build();

        log.info(authentication.getName());

        refreshTokenRepository.save(refreshToken);

        return token;
    }

    @Transactional
    public TokenDto reissue(TokenRequestDto dto) {
        // 1. RefreshToken 검증
        if(!tokenProvider.validateToken(dto.getRefreshToken())){
            throw new RuntimeException("Refresh Token 이 유효하지 않습니다.");
        }

        // 2. Access Token 에서 Member ID 가져오기
        Authentication authentication = tokenProvider.getAuthentication(dto.getAccessToken());

        // 3. 저장소에서 Member ID를 기반으로 Refresh Token 값 가져오기
        RefreshToken refreshToken = refreshTokenRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new RuntimeException("로그아웃 된 사용자입니다."));

        // 4. RefreshToken 일치하는지 검사
        if (!refreshToken.getValue().equals(dto.getRefreshToken())) {
            throw new RuntimeException("토큰의 유저 정보가 일치하지 않습니다.");
        }

        // 5. 새로운 토큰 생성
        TokenDto newToken = tokenProvider.create(authentication);
        log.info(newToken);

        // 6. 저장소 정보 업데이트
        RefreshToken newRefreshToken = refreshToken.update(newToken.getRefreshToken());
        refreshTokenRepository.save(newRefreshToken);

        return newToken;
    }
}
