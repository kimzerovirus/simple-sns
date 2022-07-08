package me.kzv.okvue.web.account;

import lombok.RequiredArgsConstructor;
import me.kzv.okvue.web.account.persistence.Account;
import me.kzv.okvue.web.account.persistence.AccountRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public Account signupWithLocalPlatform(){
        return null;
    }
}
