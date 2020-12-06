package com.pradeep.springboot.test.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.pradeep.springboot.test.domain.Customer;
import com.pradeep.springboot.test.repo.CustomerRepo;





@ExtendWith(SpringExtension.class)
@Import(CustomerRepo.class)
public class CustomerServiceTest {
	
	
	
	@TestConfiguration
    static class CustomerServiceImplTestContextConfiguration {
 
        @Bean
        public CustomerService customerService() {
            return new CustomerServiceImpl();
        }
    }
	
	
	
	
	@MockBean
	private CustomerRepo customerRepo;
	
	@Autowired
	private CustomerService customerService;
	
	
	
	
	
	
	@Test
	void getCustomer() {
		
		Customer customer =  new Customer();
		customer.setId("123");
		customer.setFirstName("John");
		customer.setLastName("Miller");	
		
		Mockito.when(customerRepo.findById("AnyId")).thenReturn(Optional.of(customer));
		
		Customer custo = customerService.getCustomer("AnyId");
		
		assertThat(custo.getFullName()).isEqualTo("John Miller");
		
		
	}
	

}
