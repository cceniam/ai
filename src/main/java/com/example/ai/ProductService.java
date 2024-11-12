package com.example.ai;

import com.example.ai.entiy.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public Product findProductByName(String name) {
        return productRepository.findByNameIgnoreCase(name);
    }
}