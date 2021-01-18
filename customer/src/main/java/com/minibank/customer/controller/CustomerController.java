package com.minibank.customer.controller;

import com.minibank.customer.domain.dto.CustomerDTO;
import com.minibank.customer.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

  @Resource(name="customerService")
  private CustomerService customerService;


  @ApiOperation(value = "고객등록", httpMethod = "POST", notes = "고객등록")
  @PostMapping("/customer/v1.0")
  public Long createCustomer(@RequestBody CustomerDTO customerDto) throws Exception{
    return customerService.createCustomer(customerDto);
  }


  @ApiOperation(value = "고객기본조회", httpMethod = "GET", notes = "고객기본조회")
  @RequestMapping(method = RequestMethod.GET, path = "/customer/v1.0/{cstmId}")
  public CustomerDTO retrieveCustomer(@PathVariable(name = "cstmId") String cstmId) throws Exception{

    //TODO : 10초 응답지연 코드 추가
    Thread.sleep(10000);

    return customerService.retrieveCustomer(cstmId);
  }

  @ApiOperation(value = "고객존재여부조회", httpMethod = "GET", notes = "고객존재여부조회")
  @RequestMapping(method = RequestMethod.GET, path ="/exists/customer/v1.0/{cstmId}")
  public Boolean existsCustomerId(@PathVariable(name = "cstmId") String cstmId) throws Exception{
    return customerService.existsCustomerId(cstmId);
  }
}
