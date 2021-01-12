package com.minibank.customer.domain.dto;

import com.minibank.customer.domain.entity.Customer;

public class CustomerDTO {

  private String customerId;
  private String name;
  private int    age;
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

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
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
    this.age = customer.getAge();
    this.gender = customer.getGender();
    this.phoneNumber = customer.getPhoneNumber();
    this.address = customer.getAddress();
  }

  public Customer toEntity() {
    return new Customer.Builder(customerId).name(name).age(age).gender(gender).phoneNumber(phoneNumber).address(address).build();
  }

}
