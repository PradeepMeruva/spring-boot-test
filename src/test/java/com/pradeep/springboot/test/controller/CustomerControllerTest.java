package com.pradeep.springboot.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import com.pradeep.springboot.test.domain.Customer;
import com.pradeep.springboot.test.service.CustomerService;


@WebMvcTest
@Import(CustomerService.class)
public class CustomerControllerTest {
	
	@MockBean
	CustomerService customerService;
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		
		Customer customer =  new Customer();
		customer.setId("123");
		customer.setFirstName("John");
		customer.setLastName("Miller");		
		
		Mockito.when(customerService.getCustomer("123")).thenReturn(customer);		
		this.mockMvc.perform(get("/customers/123")).andDo(print()).andExpect(status().isOk());
				
	}
	
	
	
}
