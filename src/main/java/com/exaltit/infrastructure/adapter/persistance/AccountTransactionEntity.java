package com.exaltit.infrastructure.adapter.persistance;

import com.exaltit.domain.model.TransactionType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class AccountTransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionNo;

    private LocalDateTime dateTransaction;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name="account_No")
    @JsonBackReference
    private AccountEntity account;

    private TransactionType transactionType;

}
