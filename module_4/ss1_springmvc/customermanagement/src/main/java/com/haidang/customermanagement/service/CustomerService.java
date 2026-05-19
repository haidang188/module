package com.haidang.customermanagement.service;

import com.haidang.customermanagement.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {
    private static Map<Integer, Customer> customers;
    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "Nguyen Van A", "nguyenvana@gmail.com", "Ha Noi"));
        customers.put(2, new Customer(2, "Nguyen Van AB", "nguyenvanab@gmail.com", "Ha Noi"));
        customers.put(3, new Customer(3, "Nguyen Van ABC", "nguyenvanabc@gmail.com", "Ha Noi"));
        customers.put(4, new Customer(4, "Nguyen Van ABCD", "nguyenvanabcd@gmail.com", "Ha Noi"));
        customers.put(5, new Customer(5, "Nguyen Van ABCDE", "nguyenvanabcde@gmail.com", "Ha Noi"));

    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }
}
