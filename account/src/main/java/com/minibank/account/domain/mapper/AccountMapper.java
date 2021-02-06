package com.minibank.account.domain.mapper;

import com.minibank.account.domain.dto.AccountDTO;
import com.minibank.account.domain.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccountMapper {

  Account toEntity(AccountDTO accountDTO);
  AccountDTO toDto(Account account);

}
