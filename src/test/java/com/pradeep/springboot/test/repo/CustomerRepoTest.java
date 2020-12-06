package com.pradeep.springboot.test.repo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.pradeep.springboot.test.domain.Customer;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:test.properties")
public class CustomerRepoTest {
	@Autowired
	private CustomerRepo customerRepo;
	
	@Test
	void findByFirstName() {
		Customer customer =  new Customer();
		customer.setId("1234");
		customer.setFirstName("John");
		customer.setLastName("Miller");				
		customerRepo.saveAndFlush(customer);	
		
		
		List<Customer> listOfCustomers = customerRepo.findByFirstName("John");		
		assertThat(listOfCustomers.isEmpty()).isEqualTo(false);
				
	}

}
