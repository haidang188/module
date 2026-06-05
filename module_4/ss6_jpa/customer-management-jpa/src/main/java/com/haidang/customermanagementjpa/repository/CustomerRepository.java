package com.haidang.customermanagementjpa.repository;

import com.haidang.customermanagementjpa.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
