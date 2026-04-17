package com.haidang.calculator.controller;

import com.haidang.calculator.model.Calculator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculate")
public class CalculatorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            double firstOperand = Double.parseDouble(request.getParameter("firstOperand"));
            double secondOperand = Double.parseDouble(request.getParameter("secondOperand"));
            String operator = request.getParameter("operator");

            double result = Calculator.calculate(firstOperand, secondOperand, operator);

            request.setAttribute("result", result);
            request.setAttribute("firstOperand", firstOperand);
            request.setAttribute("secondOperand", secondOperand);
            request.setAttribute("operator", operator);

        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }

        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
