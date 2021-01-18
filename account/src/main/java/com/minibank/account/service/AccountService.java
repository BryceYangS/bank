package com.minibank.account.service;

import com.minibank.account.domain.dto.AccountDTO;

public interface AccountService {
  boolean existsAccountNo(String accountNo) throws Exception;
  Integer createAccount(AccountDTO accountDto) throws Exception;
}
