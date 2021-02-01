package com.minibank.account.service;

import com.minibank.account.domain.dto.AccountDTO;
import com.minibank.account.domain.entity.Account;
import com.minibank.account.domain.mapper.AccountMapper;
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
  public Account retrieveAccount(String accountNo) throws Exception {
    Account account = accountRepository.findByAccountNo(accountNo);

    if(account == null){
      throw new BusinessException("존재하지 않는 계좌번호!");
    }

    return account;
  }

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


    Account account = Account.builder().accountNo(accountDto.getAccountNo())
        .accountBalance(accountDto.getAccountBalance())
        .accountNm(accountDto.getAccountNm())
        .customerId(customer.getCustomerId())
        .customerNm(customer.getName())
        .build();

    accountRepository.save(account);

    return null;
  }

}
