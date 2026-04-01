package com.example.javawebcurrencyconverter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConverterServlet", value= "/convert")
public class ConverterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float rate = Float.parseFloat(request.getParameter("rate"));
        float usd = Float.parseFloat(request.getParameter("usd"));

        float vnd = usd * rate;

        PrintWriter writer = response.getWriter();
        writer.print("<html>");
        writer.print("<h1>Rate: " + rate + "</h1>");
        writer.print("<h1>USD: " + usd + "</h1>");
        writer.print("<h1>VND: " + vnd + "</h1>");
        writer.print("</html>");

    }
}
