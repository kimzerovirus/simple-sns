package me.kzv.okvue.modules.account;

import lombok.RequiredArgsConstructor;
import me.kzv.okvue.infra.utils.CookieUtils;
import me.kzv.okvue.modules.account.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
@RestController
public class AccountController {

    private final AccountService accountService;
    private final CookieUtils cookieUtils;

    @PostMapping("/signup")
    public ResponseEntity<Account> signup(@RequestBody SignupRequestDto dto) {
        return ResponseEntity.ok(accountService.signupWithLocalPlatform(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginRequestDto dto) {
        return ResponseEntity.ok(accountService.login(dto));
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(HttpServletRequest request) {
        String ac = cookieUtils.getCookieValue(request, "ac_token");
        String rf = cookieUtils.getCookieValue(request, "rf_token");

        TokenRequestDto tokenRequestDto = TokenRequestDto.builder()
                .accessToken(ac)
                .refreshToken(rf)
                .build();

        return ResponseEntity.ok(accountService.reissue(tokenRequestDto));
    }

    @GetMapping("/logout")
    public void logout(@RequestBody LogoutRequestDto dto, HttpServletResponse response) {
        Cookie deleteAccessToken = cookieUtils.createNormalCookie("ac_token", null, 0);
        Cookie deleteRefreshToken = cookieUtils.createNormalCookie("rf_token", null, 0);

        response.addCookie(deleteAccessToken);
        response.addCookie(deleteRefreshToken);

        accountService.removeRefreshToken(dto.getEmail());
    }
}
