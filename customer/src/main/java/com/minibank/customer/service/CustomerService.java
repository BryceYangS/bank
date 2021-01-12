package com.minibank.customer.service;

import com.minibank.customer.domain.dto.CustomerDTO;

public interface CustomerService {
  public Long createCustomer(CustomerDTO customerDto) throws Exception;
  public CustomerDTO retrieveCustomer(String cstmId) throws Exception;
  public boolean existsCustomerId(String cstmId) throws Exception;
}
