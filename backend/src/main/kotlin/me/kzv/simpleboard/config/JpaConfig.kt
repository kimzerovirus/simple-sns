package me.kzv.simpleboard.config

import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.AuditorAware

@Configuration
class JpaConfig {

    @PersistenceContext
    lateinit var em: EntityManager

    @Bean
    fun auditorProvider(): AuditorAware<String> = AuditorAwareImpl()

    @Bean
    fun jpaQueryFactory(): JPAQueryFactory = JPAQueryFactory(em)
}