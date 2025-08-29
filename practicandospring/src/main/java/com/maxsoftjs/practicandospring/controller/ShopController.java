package com.maxsoftjs.practicandospring.controller;

import com.maxsoftjs.practicandospring.entity.Shop;
import com.maxsoftjs.practicandospring.service.ShopService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/shops")
public class ShopController {

    private final ShopService service;

    public ShopController(ShopService service){
        this.service=service;
    }


    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Shop> getallshops(){
        return service.getallshops();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Shop getshop(@PathVariable Long id){
        return service.getshop(id);
    }

    @PostMapping
    public Shop createshop(@RequestBody Shop shop){
        return service.saveshop(shop);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteshop(@PathVariable Long id){
        service.delete(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Shop updateshop(@PathVariable Long id,@RequestBody Shop shopdetails){
        return service.updateshop(id, shopdetails);
    }


}
