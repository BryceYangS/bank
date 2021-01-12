package com.minibank.customer.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {


  @Id @GeneratedValue
  private Long no;

  private String customerId;
  private String name;
  private int age;
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

  public int getAge() {
    return age;
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
    private int age = 0;
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
    public Builder age(int age){
      this.age = age;
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
     age = builder.age;
     gender = builder.gender;
     phoneNumber = builder.phoneNumber;
     address = builder.address;
  }

}
