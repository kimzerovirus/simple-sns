package me.kzv.okvue.security.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    private final String SECRET_KEY;

    public JwtTokenProvider(@Value("${jwt.secret}") String key){
        SECRET_KEY = key;
    }
}
