package com.first.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.first.demo.model.Product;
import com.first.demo.repository.ProductRepository;

@Service
public class ProductService {

//    public ProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with id: " + id));
    }

    public Product createProduct(Product product) {
    	String description = product.getDescription();
        String category = product.getCategory();
        double price = product.getPrice();

        // Save the description, category, and price to the product entity
        product.setDescription(description);
        product.setCategory(category);
        product.setPrice(price);

        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
