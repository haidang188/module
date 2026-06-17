package com.haidang.customermanageaspect.service;

import com.haidang.customermanageaspect.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll() throws Exception;
    Customer findOne(Long id) throws Exception;
}
