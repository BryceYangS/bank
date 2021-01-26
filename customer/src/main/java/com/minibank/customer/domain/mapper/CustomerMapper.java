package com.minibank.customer.domain.mapper;

import com.minibank.customer.domain.dto.CustomerDTO;
import com.minibank.customer.domain.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

  CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

  Customer toEntity(CustomerDTO customerDto);
  CustomerDTO toDto(Customer customer);
}
