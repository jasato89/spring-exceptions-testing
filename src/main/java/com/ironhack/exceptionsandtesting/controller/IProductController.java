package com.ironhack.exceptionsandtesting.controller;

import com.ironhack.exceptionsandtesting.model.Product;

import java.util.List;

public interface IProductController {

    Product findById(long id);
    List<Product> findAll();
    void deleteById(long id);
    Product updateProduct(Product product);
    Product addProduct(Product product);

}

