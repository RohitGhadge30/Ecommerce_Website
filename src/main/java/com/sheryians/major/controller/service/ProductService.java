package com.sheryians.major.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.sheryians.major.model.Product;

import com.sheryians.major.repository.ProductRepo;

@Service
public class ProductService {


    @Autowired
    ProductRepo productrepo;

     public List<Product> getAllProduct(){
        return productrepo.findAll();
      }

      public void addProduct(Product prod){
        productrepo.save(prod);
      }

      public void removeProductById(long id){
        productrepo.deleteById(id);
      }


      public Optional<Product> getProductById(long id){
        return productrepo.findById(id);
      }

      public List<Product> getAllProductByCategoryId(int id){
        return productrepo.findAllByCategory_Id(id);
      }
      
      



}
