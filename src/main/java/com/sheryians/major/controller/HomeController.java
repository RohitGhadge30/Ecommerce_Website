package com.sheryians.major.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sheryians.major.controller.service.CategoryService;
import com.sheryians.major.controller.service.ProductService;

@Controller
public class HomeController {


    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @GetMapping({"/", "/home"})
    public String Home(Model model) {
        return "index";
    }

    @GetMapping("/shop")
    public String Shop(Model model) {
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products",productService.getAllProduct());
        return "shop";
    }

    @GetMapping("/shop/category/{id}")
    public String shopByCategory(Model model,@PathVariable int id) {
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products",productService.getAllProductByCategoryId(id));
        return "shop";
    }

    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(Model model,@PathVariable int id) {
        model.addAttribute("product",productService.getProductById(id).get());
        return "viewProduct";
    }


    


}
