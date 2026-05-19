package com.haidang.customermanagement.service;

import com.haidang.customermanagement.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(int id);
}
