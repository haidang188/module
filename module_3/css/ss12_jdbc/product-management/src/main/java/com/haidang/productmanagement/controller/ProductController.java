package com.haidang.productmanagement.controller;

import com.haidang.productmanagement.model.Category;
import com.haidang.productmanagement.model.Product;
import com.haidang.productmanagement.repository.CategoryRepository.CategoryRepository;
import com.haidang.productmanagement.repository.ProductRepository.ProductRepository;
import com.haidang.productmanagement.service.CategoryService.CategoryService;
import com.haidang.productmanagement.service.ProductService.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductController extends HttpServlet {
    private ProductService productService = new ProductService();
    private CategoryService categoryService = new CategoryService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "";

        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "search":
                searchProduct(request, response);
                break;
            default:
                listProduct(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {
            case "create":
                insertProduct(request, response);
                break;
            case "edit":
                updateProduct(request, response);
                break;
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int page = 1;
        int limit = 5;

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        int offset = (page - 1) * limit;

        List<Product> products = productService.findAll(limit, offset);

        request.setAttribute("products", products);
        request.setAttribute("currentPage", page);

        request.getRequestDispatcher("product/list.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Category> categories = categoryService.findAll();

        request.setAttribute("categories", categories);
        request.getRequestDispatcher("product/create.jsp").forward(request, response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String name = request.getParameter("name");
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(request.getParameter("price")));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        Product product = new Product(0, name, price, quantity, categoryId);

        productService.insert(product);

        response.sendRedirect("/products");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Product product = productService.findById(id);
        List<Category> categories = categoryService.findAll();

        request.setAttribute("product", product);
        request.setAttribute("categories", categories);

        request.getRequestDispatcher("product/edit.jsp").forward(request, response);
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(request.getParameter("price")));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        Product product = new Product(id, name, price, quantity, categoryId);

        productService.update(product);

        response.sendRedirect("/products");
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        productService.delete(id);

        response.sendRedirect("/products");
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String keyword = request.getParameter("keyword");

        List<Product> products = productService.search(keyword);

        request.setAttribute("products", products);

        request.getRequestDispatcher("product/list.jsp").forward(request, response);
    }



}
