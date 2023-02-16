package me.kzv.simpleboard.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.AuditorAware
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@Configuration
class JpaConfig {

    @Bean
    fun auditorProvider(): AuditorAware<String> = AuditorAwareImpl()
}