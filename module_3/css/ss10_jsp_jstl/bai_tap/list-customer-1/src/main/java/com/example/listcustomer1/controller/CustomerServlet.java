package com.example.listcustomer1.controller;

import com.example.listcustomer1.model.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customersList = new ArrayList<>();
        customersList.add(new Customer("Mai Văn Hoàn", "1983-08-20", "Hà Nội", "images/img_1.jpeg"));
        customersList.add(new Customer("Nguyễn Văn Nam", "1988-06-30", "Hà Nội", "images/img2.jpg"));
        customersList.add(new Customer("Nguyễn Thái Hòa", "1989-03-23", "Hà Nội", "images/img3.jpg"));
        customersList.add(new Customer("Trần Đăng Khoa", "1985-01-11", "Hà Nội", "images/img4.jpg"));
        customersList.add(new Customer("Nguyễn Đình Thi", "1982-09-22", "Hà Nội", "images/img5.jpg"));

        request.setAttribute("customersList", customersList);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
