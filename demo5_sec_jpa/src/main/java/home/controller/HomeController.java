package home.controller;

import home.entity.Product;
import home.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {
    
    @Autowired
    private ProductServiceImpl service;
    
    // Thêm mapping cho login page
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    
    @GetMapping({"/", "/home"})
    public String viewHomePage(Model model) {
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);
        return "index";
    }
    
    @GetMapping("/new")
    public String showNewProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "new_product";
    }
    
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        service.save(product);
        return "redirect:/";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable(name = "id") Long id, Model model) {
        Product product = service.get(id);
        model.addAttribute("product", product);
        return "edit_product";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
    
    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }
}