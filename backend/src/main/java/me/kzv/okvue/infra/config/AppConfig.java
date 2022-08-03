package me.kzv.okvue.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 시큐리티에서 로그인 된 사용자 정보를 가져와 등록자 자동 처리
//    @Bean
//    public AuditorAware<String> auditorProvider() {
//        return () -> Optional.of(SecurityUtils.getCurrentMemberId());
//    }

//    // 로컬 테스트용 설정
//    @Bean
//    public CorsFilter corsFilter(){
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);
//        config.addAllowedOrigin("*");
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//
//        source.registerCorsConfiguration("/api/**", config);
//        return new CorsFilter(source);
//    }
}
