package com.exaltit.domain.port.output;

import com.exaltit.domain.model.Account;

import java.util.Optional;

public interface LoadAccount {

    Optional<Account> load(Long accountNo);

}
