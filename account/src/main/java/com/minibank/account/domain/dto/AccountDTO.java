package com.minibank.account.domain.dto;


import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO {

  private String accountNo;
  private String customerId;
  private String customerNm;
  private String accountNm;
  private LocalDateTime newDtm;
  private Long accountBalance;

}
