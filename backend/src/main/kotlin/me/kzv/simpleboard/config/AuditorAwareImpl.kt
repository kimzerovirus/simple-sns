package me.kzv.simpleboard.config

import org.springframework.data.domain.AuditorAware
import java.util.*


class AuditorAwareImpl : AuditorAware<String> {
    override fun getCurrentAuditor(): Optional<String> {
        // TODO SecurityContextHolder.getContext
        return Optional.of("테스트 유저")
    }
}
