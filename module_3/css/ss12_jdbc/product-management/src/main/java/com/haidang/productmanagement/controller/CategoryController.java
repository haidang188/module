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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CategoryServlet", urlPatterns = "/categories")
public class CategoryController extends HttpServlet {
    private ProductService productService = new ProductService();
    private CategoryService categoryService = new CategoryService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "";

        switch (action) {
            case "view":
                viewCategoryWithProducts(request, response);
                break;
            default:
                listCategory(request, response);
        }
    }
    private void listCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Category> categories = categoryService.findAll();

        request.setAttribute("categories", categories);

        request.getRequestDispatcher("category/list.jsp").forward(request, response);
    }

    private void viewCategoryWithProducts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Category> categories = categoryService.findAll();

        Map<Integer, List<Product>> categoryProducts = new HashMap<>();

        for (Category c : categories) {
            List<Product> products = productService.findByCategory(c.getId());
            categoryProducts.put(c.getId(), products);
        }

        request.setAttribute("categories", categories);
        request.setAttribute("categoryProducts", categoryProducts);

        request.getRequestDispatcher("category/view.jsp").forward(request, response);
    }


}
