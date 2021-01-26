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

  public CustomerDTO(Customer customer) {
    this.customerId = customer.getCustomerId();
    this.name = customer.getName();
    this.birthDay = customer.getBirthDay();
    this.gender = customer.getGender();
    this.phoneNumber = customer.getPhoneNumber();
    this.address = customer.getAddress();
  }

}
