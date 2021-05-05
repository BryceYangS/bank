package com.minibank.account.rest.customer.entity;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
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

}