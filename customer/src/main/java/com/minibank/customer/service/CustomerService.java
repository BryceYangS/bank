package com.minibank.customer.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minibank.customer.domain.dto.CustomerDTO;
import com.minibank.customer.domain.entity.Customer;
import com.minibank.customer.domain.repository.CustomerRepository;
import com.minibank.customer.exception.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

	private final CustomerRepository customerRepository;
	private final ModelMapper modelMapper;

	@Transactional(rollbackFor = Exception.class)
	public Long createCustomer(Customer customer) throws Exception {

		if (existsCustomerId(customer.getCustomerId())) {
			throw new BusinessException("이미 존재하는 아이디입니다.");
		}

		return customerRepository.save(customer).getNo();
	}

	@Transactional(readOnly = true)
	public CustomerDTO retrieveCustomer(String cstmId) throws Exception {

		if (!existsCustomerId(cstmId)) {
			throw new BusinessException("존재하지 않는 아이디입니다.");
		}

		Customer customer = customerRepository.findByCustomerId(cstmId)
			.orElseThrow(() -> new BusinessException("고객 데이터를 조회하지 못했습니다."));
 
		return modelMapper.map(customer, CustomerDTO.class);
	}

	@Transactional(readOnly = true)
	public boolean existsCustomerId(String cstmId) throws Exception {
		return customerRepository.existsByCustomerId(cstmId);
	}
}
