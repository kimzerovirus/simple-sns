package me.kzv.okvue.infra.config;

import lombok.RequiredArgsConstructor;
import me.kzv.okvue.infra.security.jwt.JwtAccessDeniedHandler;
import me.kzv.okvue.infra.security.jwt.JwtAuthenticationEntryPoint;
import me.kzv.okvue.infra.security.jwt.JwtAuthenticationFilter;
import me.kzv.okvue.infra.security.jwt.JwtTokenProvider;
import me.kzv.okvue.infra.security.oauth2.CustomOAuth2FailureHandler;
import me.kzv.okvue.infra.security.oauth2.CustomOAuth2SuccessHandler;
import me.kzv.okvue.infra.security.oauth2.CustomOAuth2UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;
    private final CustomOAuth2SuccessHandler successHandler;
    private final CustomOAuth2FailureHandler failureHandler;
    private final JwtTokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()

                .and()
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                // h2-console설정
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/", "/login", "/admin/login", "/api/v1/account").permitAll()
//                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
//                .anyRequest().authenticated()
                .antMatchers("/admin/**").authenticated()
                .anyRequest().permitAll()

                .and()
                .formLogin().loginPage("/admin/login").permitAll() // 어드민페이지 로그인 페이지

                .and()
                .logout().logoutSuccessUrl("/admin").permitAll()

                .and()
                .oauth2Login()
                .loginPage("/login") // 스프링 기본 로그인 페이지 사용 안하려면 매핑해줘야함
                .userInfoEndpoint()
                .userService(customOAuth2UserService)

                .and()
                .successHandler(successHandler)
                .failureHandler(failureHandler)

        ;

//        http.headers().frameOptions().sameOrigin();
        JwtAuthenticationFilter customFilter = new JwtAuthenticationFilter(tokenProvider);
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**", "/favicon.ico");
    }
}
