package com.minibank.customer.controller;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.minibank.customer.domain.dto.CustomerDTO;
import com.minibank.customer.domain.entity.Customer;
import com.minibank.customer.service.CustomerService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CustomerController {

	private final CustomerService customerService;
	private final ModelMapper modelMapper;

	@ApiOperation(value = "고객등록", httpMethod = "POST", notes = "고객등록")
	@PostMapping("/customer/v1.0")
	public Long createCustomer(@RequestBody CustomerDTO customerDto) throws Exception {
		Customer customer = modelMapper.map(customerDto, Customer.class);
		return customerService.createCustomer(customer);
	}

	@ApiOperation(value = "고객기본조회", httpMethod = "GET", notes = "고객기본조회")
	@GetMapping("/customer/v1.0/{cstmId}")
	public CustomerDTO retrieveCustomer(@PathVariable(name = "cstmId") String cstmId) throws Exception {

		//TODO : 10초 응답지연 코드 추가
		//    Thread.sleep(10000);\

		return customerService.retrieveCustomer(cstmId);
	}

	@ApiOperation(value = "고객존재여부조회", httpMethod = "GET", notes = "고객존재여부조회")
	@GetMapping("/exists/customer/v1.0/{cstmId}")
	public Boolean existsCustomerId(@PathVariable String cstmId) throws Exception {
		return customerService.existsCustomerId(cstmId);
	}
}
