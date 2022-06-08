package com.ironhack.exceptionsandtesting.service.impl;

import com.ironhack.exceptionsandtesting.model.Product;
import com.ironhack.exceptionsandtesting.repository.ProductRepository;
import com.ironhack.exceptionsandtesting.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.FileNotFoundException;
import java.util.List;
@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepository productRepository;


    public Product findById(long id) {
        if (productRepository.findById(id).isPresent()) {
            return productRepository.findById(id).get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedro!!!!!! Product not found");
        }
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void deleteById(long id) {
        productRepository.deleteById(id);

    }

    public Product updateProduct(Product product) {
        if (productRepository.findById(product.getId()).isPresent()) {
            productRepository.save(product);

        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product couldn't be updated");
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
}
