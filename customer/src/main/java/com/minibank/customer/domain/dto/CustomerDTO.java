package com.minibank.customer.domain.dto;

import com.minibank.customer.domain.entity.Customer;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {

  private String customerId;
  private String name;
  private LocalDate birthDay;
  private String gender;
  private String phoneNumber;
  private String address;

  public CustomerDTO() {
    super();
  }

}
