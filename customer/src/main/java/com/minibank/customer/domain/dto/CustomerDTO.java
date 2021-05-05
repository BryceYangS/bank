package com.minibank.customer.domain.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CustomerDTO {

	private String customerId;
	private String name;
	private LocalDate birthDay;
	private String gender;
	private String phoneNumber;
	private String address;

}
