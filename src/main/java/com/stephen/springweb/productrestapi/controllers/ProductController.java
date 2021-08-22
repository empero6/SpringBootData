package com.stephen.springweb.productrestapi.controllers;

import java.util.*;
import com.stephen.springweb.productrestapi.entities.Product;
import com.stephen.springweb.productrestapi.repos.ProductRepository;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController //makes this class a rest controller
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ProductController.class);

    @RequestMapping(value = "/products/", method=RequestMethod.GET)
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @RequestMapping(value = "/products/{id}", method=RequestMethod.GET)
    public Product getProduct(@PathVariable("id") int id) {
        LOGGER.info("Getting product by ID " + id);
        return productRepository.findById(id).get();
    }

    @RequestMapping(value = "/products/", method=RequestMethod.POST)
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @RequestMapping(value = "/products/", method=RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @RequestMapping(value = "/products/{id}", method=RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("id") int id) {
         productRepository.deleteById(id);
    }

}
