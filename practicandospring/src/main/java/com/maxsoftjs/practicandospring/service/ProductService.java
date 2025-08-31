package com.maxsoftjs.practicandospring.service;

import com.maxsoftjs.practicandospring.entity.Product;
import com.maxsoftjs.practicandospring.repository.ProductRepository;
import com.maxsoftjs.practicandospring.entity.User;
import com.maxsoftjs.practicandospring.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;
    private final UserRepository userRepository;

    public ProductService(ProductRepository repo, UserRepository userRepository){
        this.repo=repo;
        this.userRepository = userRepository;
    }


    //GETS
    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public Product getProduct(Long id){
        return repo.findById(id)
                .orElseThrow(()-> new RuntimeException("Not found product with id: "+id));
    }

    //CREATE O POST
    public Product saveProduct(Product product){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        User user = userRepository.findByUsername(name)
                .orElseThrow(()->new RuntimeException("Not found user with name: "+ name));

        product.setUser(user);

        return repo.save(product);
    }

    //DELETE
    public void deleteProduct(Long id){
        repo.deleteById(id);
    }

    //MODIFY O  UPDATE

    public Product updateProduct(Long id, Product productDetails){
        Product product = repo.findById(id)
                .orElseThrow(()-> new RuntimeException("Not found user with id: "+ id));

        product.setProduct_name(productDetails.getProduct_name());
        product.setPrice(productDetails.getPrice());

        return repo.save(product);
    }


}
