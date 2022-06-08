package com.ironhack.exceptionsandtesting.controller.impl;

import com.ironhack.exceptionsandtesting.controller.IProductController;
import com.ironhack.exceptionsandtesting.model.Product;
import com.ironhack.exceptionsandtesting.repository.ProductRepository;
import com.ironhack.exceptionsandtesting.service.IProductService;
import com.ironhack.exceptionsandtesting.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/products/")
public class ProductController implements IProductController {

    @Autowired
    IProductService productService;

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product findById(@PathVariable long id) {
        return productService.findById(id);
    }

    @GetMapping("find-all")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAll() {
        return productService.findAll();
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable long id) {
        productService.deleteById(id);
    }

    @PatchMapping("update/")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @PostMapping("add/")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
}
