package me.kzv.board.utils

import org.springframework.stereotype.Component
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest


@Component
class CookieUtils {
    fun createNormalCookie(key: String, value: String, maxAge: Int): Cookie {
        return create(key, value, maxAge, false)
    }

    fun createHttpOnlyCookie(key: String, value: String, maxAge: Int): Cookie {
        return create(key, value, maxAge, true)
    }

    fun getCookieValue(request: HttpServletRequest, key: String): String? {
        val cookies: Array<Cookie> = request.cookies
        if (cookies != null) {
            for (cookie in cookies) {
                if (cookie.name.equals(key)) {
                    return cookie.value
                }
            }
        }

        return null
    }

    private fun create(key: String, value: String, maxAge: Int, isHttpOnly: Boolean): Cookie {
        val cookie = Cookie(key, value)
        cookie.path = "/"
        cookie.maxAge = maxAge
        cookie.isHttpOnly = isHttpOnly

        return cookie
    }
}