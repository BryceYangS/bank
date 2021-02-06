package com.minibank.account.domain.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@Entity
@Getter
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

}
