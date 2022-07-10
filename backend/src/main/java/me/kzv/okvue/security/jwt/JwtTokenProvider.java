package me.kzv.okvue.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import me.kzv.okvue.web.account.persistence.Account;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private final Key SECRET_KEY;

    public JwtTokenProvider(@Value("${jwt.secret}") String key){
        byte[] keyBytes = Decoders.BASE64.decode(key);
        SECRET_KEY = Keys.hmacShaKeyFor(keyBytes);
    }

    public String create(Account account){
        Date expiryDate = Date.from(
                Instant.now().plus(6, ChronoUnit.HOURS)
        );

        String refreshToken = Jwts.builder()
                .setExpiration(expiryDate)
                .signWith(SECRET_KEY, SignatureAlgorithm.HS512)
                .compact();

        return Jwts.builder()
                .signWith(SECRET_KEY, SignatureAlgorithm.HS512)
                .setSubject(account.getEmail())
                .setIssuer("KZV")
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .compact();
    }

    public String validateAndGetAccountId(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}
