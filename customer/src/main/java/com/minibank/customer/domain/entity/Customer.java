package com.minibank.customer.domain.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Customer {


  @Id @GeneratedValue
  private Long no;

  private String customerId;
  private String name;
  private LocalDate birthDay;
  private String gender;
  private String phoneNumber;
  private String address;

  public Long getNo() {
    return no;
  }
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

  public static class Builder {

    // Required parameters
    private final String customerId;

    // Optional parameters
    private String name;
    private LocalDate birthDay;
    private String gender;
    private String phoneNumber;
    private String address;

    public Builder(String customerId) {
      this.customerId = customerId;
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
