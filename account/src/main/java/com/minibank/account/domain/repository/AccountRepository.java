package com.minibank.account.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minibank.account.domain.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	Optional<Account> findByAccountNo(String accountNo) throws Exception;

}
