package com.gabrielmttl.customer.repository;

import com.gabrielmttl.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
