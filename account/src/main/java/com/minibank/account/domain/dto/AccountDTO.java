package com.minibank.account.domain.dto;


import java.time.LocalDateTime;
import lombok.Data;

@Data
public class AccountDTO {

  private String accountNo;
  private String accountNm;
  private Long accountBalance;
  private String customerId;
  private String customerNm;
  private LocalDateTime newDtm;

}
