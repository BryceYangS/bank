package com.minibank.account.domain.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

  @Id
  @GeneratedValue
  private Long id;

  private String accountNo;
  private String accountNm;
  private Long accountBalance;
  private String customerId;
  private String customerNm;
  private LocalDateTime newDtm;

//  public static class Builder {
//    // Required
//    private final String accountNo;
//
//    // Optional
//    private String accountNm;
//    private Long accountBalance;
//    private String customerId;
//    private String customerNm;
//    private LocalDateTime newDtm = LocalDateTime.now();
//
//    public Builder(String accountNo) {this.accountNo = accountNo;}
//
//    public Builder accountNm(String accountNm){this.accountNm = accountNm; return this;}
//    public Builder accountBalance(Long accountBalance){this.accountBalance = accountBalance; return this;}
//    public Builder customerId(String customerId){this.customerId = customerId; return this;}
//    public Builder customerNm(String customerNm){this.customerNm = customerNm; return this;}
//    public Builder newDtm(LocalDateTime newDtm){this.newDtm = newDtm; return this;}
//
//    public Account build() {return new Account(this);}
//  }
//
//  private Account(Builder builder) {
//    accountNo = builder.accountNo;
//    accountNm = builder.accountNm;
//    accountBalance = builder.accountBalance;
//    customerId = builder.customerId;
//    customerNm = builder.customerNm;
//    newDtm = builder.newDtm;
//  }

}
