package com.example.demo.customer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.customer.domain.Customer;
import com.example.demo.customer.repository.CustomerRepository;

@SpringBootTest
public class CustomerRepositoryTest {

	@Autowired
	CustomerRepository repo;
	
	@AfterEach
	public void cleanup() {
		repo.deleteAll();
	}
	
	@Test
	public void 저장_조회() {
		// given - test 할 값
		String name = "홍길동";
		String phone = "010-1111";
		
		Customer customer = Customer.builder()
									.name(name)
									.phone(phone)
									.build();
		
		repo.save(customer);
				
		// when - test
		List<Customer> list = repo.findByNameLike(name);
		
		// then - test 결과확인
		Customer result = list.get(0);
		assertThat( result.getName() ).isEqualTo(name);
	}
}
