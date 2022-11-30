package me.kzv.board.security.provider

import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.*


@Component
class JwtTokenProvider {
//    private val log = LoggerFactory.getLogger(javaClass)

    companion object {
        private const val AUTHORITIES_KEY = "auth"
        private const val BEARER_TYPE = "bearer "
        private const val ISSUER_NAME = "kzv"
        private const val ACCESS_TOKEN_EXPIRE_MINUTES: Long = 30
        private const val REFRESH_TOKEN_EXPIRE_DAYS: Long = 7
    }

    @Value("\${jwt.secret}")
    private lateinit var secret: String
    private val key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret))

    private val accessTokenExpiresIn: Date =
        Date.from(Instant.now().plus(ACCESS_TOKEN_EXPIRE_MINUTES, ChronoUnit.MINUTES))
    private val refreshTokenExpiresIn: Date =
        Date.from(Instant.now().plus(REFRESH_TOKEN_EXPIRE_DAYS, ChronoUnit.DAYS))

    fun createToken() {

    }


}

