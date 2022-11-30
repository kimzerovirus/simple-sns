package me.kzv.board.config

import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig(

) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .headers().frameOptions().disable()
            .and()

            // url 권한 설정
            .authorizeRequests()
            .antMatchers("/h2-console/**")
            .permitAll()

            .antMatchers("/", "/api/v1/signin", "/api/v1/signup")
            .permitAll()
            .antMatchers("/api/v1/member/**").hasRole("member")
            .antMatchers("/api/v1/admin/**").hasRole("ADMIN")
            .anyRequest().authenticated()

            // 기본 인증 로그인 disable
            .and()
            .formLogin().disable()
            .logout().disable()
            .httpBasic().disable()


        return http.build()
    }

    @Bean
    fun webSecurityCustomizer(): WebSecurityCustomizer = WebSecurityCustomizer { web: WebSecurity ->
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations())
//        web.ignoring().mvcMatchers("/vendor/**")
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}