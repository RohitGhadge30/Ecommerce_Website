package com.sheryians.major.controller.service;

import org.springframework.stereotype.Service;

import com.sheryians.major.model.Category;
import com.sheryians.major.repository.CategoryRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CategoryService {


    @Autowired
      CategoryRepo categoryRepo;

      public List<Category> getAllCategory(){
        return categoryRepo.findAll();
      }

     public void addCategory(Category category){
        categoryRepo.save(category);
     }

     public void removeCatById(int id){
      categoryRepo.deleteById(id);
     }

     public Optional<Category> getCatById(int id){
      return categoryRepo.findById(id);
     }
}
