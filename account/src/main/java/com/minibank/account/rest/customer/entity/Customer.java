package com.minibank.account.rest.customer.entity;

import java.time.LocalDate;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Customer {

  private String customerId;
  private String name;
  private LocalDate birthDay;
  private String gender;
  private String phoneNumber;
  private String address;

  /*이체 한도 정보*/
  private Long oneTmTrnfLmt;
  private Long oneDyTrnfLmt;

  public String getCustomerId() {
    return customerId;
  }
  public String getName() {
    return name;
  }
  public LocalDate getBirthDay() {
    return birthDay;
  }
  public String getGender() {
    return gender;
  }
  public String getPhoneNumber() {
    return phoneNumber;
  }
  public String getAddress() {
    return address;
  }
  public Long getOneTmTrnfLmt() { return oneTmTrnfLmt; }
  public Long getOneDyTrnfLmt() { return oneDyTrnfLmt; }

  public static class Builder {

    private String customerId;
    private String name;
    private LocalDate birthDay;
    private String gender;
    private String phoneNumber;
    private String address;

    public Builder customerId (String customerId) {
      this.customerId = customerId;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }
    public Builder birthDay(LocalDate birthDay){
      this.birthDay = birthDay;
      return this;
    }
    public Builder gender(String gender) {
      this.gender = gender;
      return this;
    }
    public Builder phoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
    }
    public Builder address(String address) {
      this.address = address;
      return this;
    }

    public Customer build() {
      return new Customer(this);
    }
  }

  private Customer(Builder builder) {
    customerId = builder.customerId;
    name = builder.name;
    birthDay = builder.birthDay;
    gender = builder.gender;
    phoneNumber = builder.phoneNumber;
    address = builder.address;
  }

}