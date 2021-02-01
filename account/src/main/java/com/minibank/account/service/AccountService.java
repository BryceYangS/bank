package com.minibank.account.service;

import com.minibank.account.domain.dto.AccountDTO;
import com.minibank.account.domain.entity.Account;

public interface AccountService {
  boolean existsAccountNo(String accountNo) throws Exception;
  Integer createAccount(AccountDTO accountDto) throws Exception;
  Account retrieveAccount(String accountNo) throws Exception;

}
