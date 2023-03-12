package com.exaltit.infrastructure.adapter.persistance;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountNo;

    private BigDecimal balance;

    @OneToMany(mappedBy = "account")
    @JsonManagedReference
    private List<AccountTransactionEntity> transactions;

}
