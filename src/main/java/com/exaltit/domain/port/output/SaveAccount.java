package com.exaltit.domain.port.output;

import com.exaltit.domain.model.Account;

public interface SaveAccount {
    public Long save(Account account);
}
