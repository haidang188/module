package com.haidang.springcustomermanagementrestful.service;

import com.haidang.springcustomermanagementrestful.model.Customer;

import java.util.Optional;

public interface ICustomerService {
    Iterable<Customer> findAll();
    Optional<Customer> findById(Long id);
    Customer save(Customer customer);
    void remove(Long id);
}
