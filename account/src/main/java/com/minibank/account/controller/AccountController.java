package com.minibank.account.controller;

import com.minibank.account.domain.dto.AccountDTO;
import com.minibank.account.service.AccountService;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

  private final AccountService accountService;


  @ApiOperation(value = "계좌등록", httpMethod = "POST", notes = "계좌를 등록합니다.")
  @PostMapping("/account/v1.0")
  public Integer createAccount(@RequestBody AccountDTO accountDto) throws Exception{
    return accountService.createAccount(accountDto);
  }
}