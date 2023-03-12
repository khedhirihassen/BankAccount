package com.exaltit.infrastructure.config;

import com.exaltit.domain.service.AccountService;
import com.exaltit.infrastructure.adapter.AccountAdapter;
import com.exaltit.infrastructure.adapter.TransactionAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    AccountService bankAccountService(AccountAdapter service, TransactionAdapter transactionAdapter) {
        return new AccountService(service, service, transactionAdapter);
    }
}
