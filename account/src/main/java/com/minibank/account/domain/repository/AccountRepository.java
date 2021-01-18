package com.minibank.account.domain.repository;

import com.minibank.account.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
  Account findByAccountNo(String accountNo) throws Exception;

}
