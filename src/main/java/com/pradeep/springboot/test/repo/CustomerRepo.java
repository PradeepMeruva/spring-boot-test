package com.pradeep.springboot.test.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pradeep.springboot.test.domain.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {
	
	List<Customer> findByFirstName(String firstName);
	

	

}
