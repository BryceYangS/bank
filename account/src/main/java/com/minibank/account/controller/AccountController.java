package com.minibank.account.controller;

import com.minibank.account.domain.dto.AccountDTO;
import com.minibank.account.domain.entity.Account;
import com.minibank.account.service.AccountService;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

  private final AccountService accountService;

  @ApiOperation(value = "계좌조회", httpMethod = "GET", notes = "계좌 정보를 조회합니다.")
  @GetMapping("/rest/v1.0/{accountNo}")
  public Account retrieveAccount(@PathVariable String accountNo) throws Exception{
    return accountService.retrieveAccount(accountNo);
  }


  @ApiOperation(value = "계좌등록", httpMethod = "POST", notes = "계좌를 등록합니다.")
  @PostMapping("/rest/v1.0")
  public Integer createAccount(@RequestBody AccountDTO accountDto) throws Exception{
    return accountService.createAccount(accountDto);
  }
}