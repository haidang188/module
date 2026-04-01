package com.example.product_discount_calculator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductServlet", urlPatterns = "/calculator")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        int discount_percent = Integer.parseInt(request.getParameter("discount"));
        float discount = (float) (price * discount_percent * 0.01);
        float total = price - discount;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1> Product Description: " + description + "</h1>");
        writer.println("<h1> Product Price: " + price + "</h1>");
        writer.println("<h1> Product Discount Percent: " + discount_percent + "%</h1>");
        writer.println("<h1> Product Discount: " + discount + "%</h1>");
        writer.println("<h1> Product Total: " + total + "</h1>");
        writer.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
