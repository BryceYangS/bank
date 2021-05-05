package com.minibank.account.rest.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.minibank.account.rest.customer.entity.Customer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerComposite {

	@Value("${customer.api.url}")
	private String customerApiUrl;

	@LoadBalanced
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(commandKey = "retrieveCustomer", fallbackMethod = "fallbackRetriveCustomer")
	public Customer retrieveCustomer(String customerId) throws Exception {
		String apiUrl = "/customer/v1.0/{cstmId}";
		return this.restTemplate.getForObject(customerApiUrl + apiUrl, Customer.class, customerId);
	}

	public Customer fallbackRetriveCustomer(String customerId, Throwable t) throws Exception {
		String msg = "restTemplate를 이용하여 " + customerId + " 고객정보 조회 서비스 호출에 문제가 있습니다.";
		log.error(msg, t);
		throw new Exception();
	}

}
