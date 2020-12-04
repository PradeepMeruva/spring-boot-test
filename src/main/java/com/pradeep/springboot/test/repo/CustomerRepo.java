package com.pradeep.springboot.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pradeep.springboot.test.domain.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {

}
