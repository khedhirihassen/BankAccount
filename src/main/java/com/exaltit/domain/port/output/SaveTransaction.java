package com.exaltit.domain.port.output;

import com.exaltit.domain.model.AccountTransaction;

public interface SaveTransaction {
    void saveTransaction(AccountTransaction transaction);
}
