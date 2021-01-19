package com.minibank.account.service;

import com.minibank.account.domain.dto.AccountDTO;
import com.minibank.account.domain.entity.Account;
import com.minibank.account.domain.repository.AccountRepository;
import com.minibank.account.rest.customer.CustomerComposite;
import com.minibank.account.rest.customer.entity.Customer;
import com.minibank.customer.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service("accountService")
public class AccountServiceImpl implements AccountService{

  private final AccountRepository accountRepository;
  private final CustomerComposite customerComposite;

  @Override
  public boolean existsAccountNo(String accountNo) throws Exception {
    if (accountRepository.findByAccountNo(accountNo) != null) {
        return true;
    }
    return false;
  }

  @Override
  public Integer createAccount(AccountDTO accountDto) throws Exception {

    if (existsAccountNo(accountDto.getAccountNo())) {
      throw new BusinessException("존재하는 계좌번호입니다.");
    }

    Customer customer = customerComposite.retrieveCustomer(accountDto.getCustomerId());


    Account account = new Account.Builder(accountDto.getAccountNo())
        .accountBalance(accountDto.getAccountBalance())
        .accountNm(accountDto.getAccountNm())
        .customerId(customer.getCustomerId())
        .customerNm(customer.getName())
        .build();

    accountRepository.save(account);

    return null;
  }

}
