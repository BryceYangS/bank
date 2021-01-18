package com.minibank.customer.domain.dto;

import com.minibank.customer.domain.entity.Customer;
import java.time.LocalDate;

public class CustomerDTO {

  private String customerId;
  private String name;
  private LocalDate birthDay;
  private String gender;
  private String phoneNumber;
  private String address;

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getBirthDay() {
    return birthDay;
  }

  public void setBirthDay(LocalDate birthDay) {
    this.birthDay = birthDay;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

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

  public Customer toEntity() {
    return new Customer.Builder(customerId).name(name).birthDay(birthDay).gender(gender).phoneNumber(phoneNumber).address(address).build();
  }

}
