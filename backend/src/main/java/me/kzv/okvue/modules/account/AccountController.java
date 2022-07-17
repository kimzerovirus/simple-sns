package me.kzv.okvue.modules.account;

import lombok.RequiredArgsConstructor;
import me.kzv.okvue.modules.account.dto.LoginRequestDto;
import me.kzv.okvue.modules.account.dto.SignupRequestDto;
import me.kzv.okvue.modules.account.dto.TokenDto;
import me.kzv.okvue.modules.account.dto.TokenRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
@RestController
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/signup")
    public ResponseEntity<Account> signup(@RequestBody SignupRequestDto dto) {
        return ResponseEntity.ok(accountService.signupWithLocalPlatform(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginRequestDto dto) {
        return ResponseEntity.ok(accountService.login(dto));
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(accountService.reissue(tokenRequestDto));
    }
}
