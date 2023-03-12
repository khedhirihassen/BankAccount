package com.exaltit.domain.port.input;


import java.math.BigDecimal;

public interface Deposit {
    void deposit(Long accountNo, BigDecimal depositAmount);
}
