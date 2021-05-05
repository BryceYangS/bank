package com.minibank.customer.service;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.minibank.customer.domain.dto.CustomerDTO;
import com.minibank.customer.domain.entity.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelMapperTest {

	@Autowired
	ModelMapper modelMapper;

	@Test
	public void modelMapperTest() {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCustomerId("id");
		customerDTO.setAddress("seoul");
		customerDTO.setBirthDay(LocalDate.now());
		customerDTO.setGender("male");
		customerDTO.setName("yang");
		customerDTO.setPhoneNumber("010-1234-1234");

		Customer customer = modelMapper.map(customerDTO, Customer.class);
		assertThat(customer.getCustomerId()).isEqualTo("id");

		Customer customer1 = Customer.builder().customerId("asdf").build();
		CustomerDTO dto = modelMapper.map(customer1, CustomerDTO.class);
		assertThat(dto.getCustomerId()).isEqualTo("asdf");
	}
}
