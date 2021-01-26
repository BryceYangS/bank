package com.minibank.customer.service;

import com.minibank.customer.domain.dto.CustomerDTO;
import com.minibank.customer.domain.entity.Customer;
import com.minibank.customer.domain.mapper.CustomerMapper;
import com.minibank.customer.domain.repository.CustomerRepository;
import com.minibank.customer.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("customerService")
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

  private final CustomerRepository customerRepository;

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Long createCustomer(CustomerDTO customerDto) throws Exception {

    if(existsCustomerId(customerDto.getCustomerId())){
      throw new BusinessException("이미 존재하는 아이디입니다.");
    }

    return customerRepository.save(CustomerMapper.INSTANCE.toEntity(customerDto)).getNo();
  }

  @Override
  public CustomerDTO retrieveCustomer(String cstmId) throws Exception {

    if(!existsCustomerId(cstmId)) {
      throw new BusinessException("존재하지 않는 아이디입니다.");
    }

    Customer customer = customerRepository.findByCustomerId(cstmId).orElse(null);

    if(customer == null){
      throw new BusinessException("고객 데이터를 조회하지 못했습니다.");
    }

//    return  new CustomerDTO(customer);
    return  CustomerMapper.INSTANCE.toDto(customer);
  }

  @Override
  public boolean existsCustomerId(String cstmId) throws Exception {
    return customerRepository.existsByCustomerId(cstmId);
  }
}
