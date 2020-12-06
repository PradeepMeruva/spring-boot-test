package com.pradeep.springboot.test.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pradeep.springboot.test.domain.Customer;
import com.pradeep.springboot.test.repo.CustomerRepo;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepo customerRepo;

	@Override
	public Customer getCustomer(String custId) {
		Customer cust = null;
		Optional<Customer> custOpt = customerRepo.findById(custId);
		
		if(custOpt.isPresent()) {
			cust =  custOpt.get();			
			cust.setFullName(cust.getFirstName() + " " +cust.getLastName() );
		}
		
		
		
		return cust;
	}

}
