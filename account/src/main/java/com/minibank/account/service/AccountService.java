package com.minibank.account.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.minibank.account.domain.dto.AccountDTO;
import com.minibank.account.domain.entity.Account;
import com.minibank.account.domain.repository.AccountRepository;
import com.minibank.account.rest.customer.CustomerComposite;
import com.minibank.account.rest.customer.entity.Customer;
import com.minibank.customer.exception.BusinessException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccountService {

	private final AccountRepository accountRepository;
	private final CustomerComposite customerComposite;
	private final ModelMapper modelMapper;

	public AccountDTO retrieveAccount(String accountNo) throws Exception {
		Account account = accountRepository.findByAccountNo(accountNo)
			.orElseThrow(() -> new BusinessException("존재하지 않는 계좌번호!"));
		return modelMapper.map(account, AccountDTO.class);
	}

	public String createAccount(Account account) throws Exception {

		if (existsAccountNo(account.getAccountNo())) {
			throw new BusinessException("존재하는 계좌번호입니다.");
		}

		Customer customer = customerComposite.retrieveCustomer(account.getCustomerId());

		account = Account.builder()
			.accountNo(account.getAccountNo())
			.accountBalance(account.getAccountBalance())
			.accountNm(account.getAccountNm())
			.customerId(customer.getCustomerId())
			.customerNm(customer.getName())
			.build();

		return accountRepository.save(account).getAccountNo();
	}

	private boolean existsAccountNo(String accountNo) throws Exception {
		return accountRepository.findByAccountNo(accountNo).isPresent();
	}

}
