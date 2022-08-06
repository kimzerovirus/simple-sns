package me.kzv.okvue.infra.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import me.kzv.okvue.modules.account.RefreshToken;
import me.kzv.okvue.modules.account.RefreshTokenRepository;
import me.kzv.okvue.modules.account.dto.TokenDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
@Component
public class JwtTokenProvider {

    private static final String AUTHORITIES_KEY = "auth";
    private static final String BEARER_TYPE = "bearer ";
    private static final String ISSUER_NAME = "kzv";
    private static final long ACCESS_TOKEN_EXPIRE_MINUTES = 30;
    private static final long REFRESH_TOKEN_EXPIRE_DAYS = 7;
    private static final Date accessTokenExpiresIn = Date.from(Instant.now().plus(ACCESS_TOKEN_EXPIRE_MINUTES, ChronoUnit.MINUTES));
    private static final Date refreshTokenExpiresIn = Date.from(Instant.now().plus(REFRESH_TOKEN_EXPIRE_DAYS, ChronoUnit.DAYS));

    private final Key SECRET_KEY;
    private final RefreshTokenRepository refreshTokenRepository;

    public JwtTokenProvider(@Value("${jwt.secret}") String key, RefreshTokenRepository refreshTokenRepository) {
        this.SECRET_KEY = Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));
        this.refreshTokenRepository = refreshTokenRepository;
    }

    @Transactional
    public TokenDto create(Authentication authentication) {
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        log.info(authentication.getName());

        // access 토큰 발급
        String accessToken = Jwts.builder()
                .setSubject(authentication.getName())
                .claim(AUTHORITIES_KEY, authorities)
                .setExpiration(accessTokenExpiresIn)
                .signWith(SECRET_KEY, SignatureAlgorithm.HS512)
                .setIssuer(ISSUER_NAME)
                .compact();

        // refresh 토큰 발급
        String refreshToken = Jwts.builder()
                .setExpiration(refreshTokenExpiresIn)
                .signWith(SECRET_KEY, SignatureAlgorithm.HS512)
                .compact();

        // refresh 토큰 db 저장 - email pk
        saveOrUpdate(authentication, refreshToken);

        return TokenDto.builder()
                .grantType(BEARER_TYPE)
                .accessToken(accessToken)
                .accessTokenExpiresIn(accessTokenExpiresIn.getTime())
                .refreshToken(refreshToken)
                .refreshTokenExpiresIn(refreshTokenExpiresIn.getTime())
                .build();
    }

    public String validateAndGetAccountId(String token) {
        Claims claims = parseClaims(token);

        if (claims.get(AUTHORITIES_KEY) == null) {
            throw new RuntimeException("권한 정보가 없는 토큰입니다.");
        }

        return claims.getSubject();
    }


    public Authentication getAuthentication(String accessToken) {
        Claims claims = parseClaims(accessToken);

        if (claims.get(AUTHORITIES_KEY) == null) {
            throw new RuntimeException("권한 정보가 없는 토큰입니다.");
        }

        // 클레임에서 권한 정보 가져오기
        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        // UserDetails 객체를 만들어서 Authentication 리턴
        UserDetails principal = new User(claims.getSubject(), "", authorities);
        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            log.info("잘못된 JWT 서명입니다.");
        } catch (ExpiredJwtException e) {
            log.info("만료된 JWT 토큰입니다.");
        } catch (UnsupportedJwtException e) {
            log.info("지원되지 않는 JWT 토큰입니다.");
        } catch (IllegalArgumentException e) {
            log.info("JWT 토큰이 잘못되었습니다.");
        }
        return false;
    }

    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(accessToken).getBody(); // Jwts모듈이 exception던짐
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

    /**
     * id 가 존재한다면 토큰만 업데이트하고 그게 아니라면 토큰을 새로 생성한다.
     */
    // TODO 기존회원이 로그인해도 토큰이 새로 생성되는 것이니깐 굳이 구별 안해도 될지도?
    private void saveOrUpdate(Authentication authentication, String refreshToken) {
        RefreshToken saveRefreshToken = refreshTokenRepository.findByEmail(authentication.getName()).map(entity -> entity.update(refreshToken))
                .orElse(RefreshToken.builder()
                        .id(authentication.getName())
                        .value(refreshToken)
                        .build());

        refreshTokenRepository.save(saveRefreshToken);
    }

}


