package com.maxsoftjs.practicandospring.service;

import com.maxsoftjs.practicandospring.entity.Shop;
import com.maxsoftjs.practicandospring.entity.User;
import com.maxsoftjs.practicandospring.repository.ShopRepository;
import com.maxsoftjs.practicandospring.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    private final ShopRepository repo;
    private final UserRepository userRepository;

    public ShopService(ShopRepository repo, UserRepository userRepository){
        this.repo = repo;
        this.userRepository = userRepository;
    }

    public List<Shop> getallshops(){
        return repo.findAll();
    }


    public Shop getshop(Long id){
        return repo.findById(id).orElseThrow(()-> new RuntimeException("Id not found: "+ id));
    }

    public Shop saveshop(Shop shop){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name= auth.getName();

        User user= userRepository.findByUsername(name)
                .orElseThrow(()-> new RuntimeException("Not foun username: "+ name));

        shop.setUser(user);
        shop.setClient(name);
        Float total= shop.getPrice()*shop.getQuantity();
        shop.setTotal(total);
        return repo.save(shop);
    }


    public void delete(Long id){
        repo.deleteById(id);
    }

    public Shop updateshop(Long id,Shop shopdetails){
        Shop shop= repo.findById(id).orElseThrow(()-> new RuntimeException("Id not found: "+ id));


        shop.setProduct(shopdetails.getProduct());
        shop.setPrice(shopdetails.getPrice());
        shop.setQuantity(shopdetails.getQuantity());

        Float total= shopdetails.getPrice()*shopdetails.getQuantity();
        shop.setTotal(total);
        return repo.save(shop);
    }




}
