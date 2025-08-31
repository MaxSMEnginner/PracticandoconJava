package com.maxsoftjs.practicandospring.controller;

import com.maxsoftjs.practicandospring.entity.Product;
import com.maxsoftjs.practicandospring.service.ProductService;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service){
        this.service=service;
    }
    //GETS
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Product getProduct(@PathVariable Long id){
        return service.getProduct(id);
    }

    //CREATE O POST
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Product saveProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }

    //DELETE
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteProduct(@PathVariable Long id){
        service.deleteProduct(id);
    }

    //MODIFY O PUT
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Product updateProduct(@PathVariable Long id,@RequestBody Product productDetails){
        return service.updateProduct(id, productDetails);
    }




}
