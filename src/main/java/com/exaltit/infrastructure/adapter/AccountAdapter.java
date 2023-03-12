package com.exaltit.infrastructure.adapter;

import com.exaltit.domain.model.Account;
import com.exaltit.domain.port.output.LoadAccount;
import com.exaltit.domain.port.output.SaveAccount;
import com.exaltit.infrastructure.adapter.mapper.AccountMapper;
import com.exaltit.infrastructure.adapter.persistance.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountAdapter implements LoadAccount, SaveAccount {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Optional<Account> load(Long accountNo) {

        Optional<AccountEntity> accountEntity = accountRepository.findById(accountNo);

        return Optional.ofNullable(AccountMapper.INSTANCE.accountEntityToAccount(accountEntity.get()));

    }

    @Override
    public void save(Account account) {

        AccountEntity accountEntity = AccountMapper.INSTANCE.accountToAccountEntity(account);

        accountRepository.save(accountEntity);
    }
}
