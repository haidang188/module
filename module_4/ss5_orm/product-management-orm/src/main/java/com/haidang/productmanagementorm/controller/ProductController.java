package com.haidang.productmanagementorm.controller;

import com.haidang.productmanagementorm.model.Product;
import com.haidang.productmanagementorm.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("products", productService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/products";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/products";
    }
    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable Integer id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "delete";
    }
    @PostMapping("/delete")
    public String delete(@ModelAttribute Product product) {
        productService.delete(product.getId());
        return "redirect:/products";
    }
}
