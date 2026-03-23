package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService){this.productService=productService;}

    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product)
    {
        return productService.saveproduct(product);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return productService.fetchAllProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable Long id)
    {
        return productService.fetchProductById(id);
    }


    @PutMapping(path="/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value="productId")
                                                 Long productId, @RequestBody Product product)
    {
        return productService.updateProduct(productId,product);
    }

    @DeleteMapping(value="/products/{productid}")
    public String deleteproduct(@PathVariable Long productId)
    {
        productService.deleteProduct(productId);
        return "Product Deleted Successfully against id "
                + productId + " ";
    }


}
