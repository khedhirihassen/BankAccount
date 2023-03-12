package com.exaltit.domain.port.input;


import java.math.BigDecimal;

public interface Withdraw {
    void withdraw(Long accountNo, BigDecimal withdrawalAmount);
}
