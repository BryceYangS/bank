package com.minibank.customer.domain.mapper;

import com.minibank.customer.domain.dto.CustomerDTO;
import com.minibank.customer.domain.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
  Customer toEntity(CustomerDTO customerDto);
  CustomerDTO toDto(Customer customer);
}
