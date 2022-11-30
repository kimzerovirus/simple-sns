package me.kzv.board.security.token

data class JwtToken(
    val accessToken: String,
    val refreshToken: String,
)