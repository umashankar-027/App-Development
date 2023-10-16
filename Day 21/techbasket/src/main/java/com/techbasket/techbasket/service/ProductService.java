package com.techbasket.techbasket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techbasket.techbasket.db.ProductDB;
import com.techbasket.techbasket.entity.ProductEntity;

@Service
public class ProductService {

     @Autowired
     ProductDB productDB;

     public Iterable<ProductEntity> getAll() {
          return productDB.findAll();
     }

     public List<ProductEntity> getMostIn() {
          return productDB.getMostIn();
     }

     public List<ProductEntity> findSearch(String name, int page) {
          return productDB.findSearch(name, ((page - 1) * 10));
     }

     public long getTotalOf(String name) {
          return productDB.getTotalOf(name);
     }

     public List<ProductEntity> getMostRe() {
          return productDB.getMostRe();
     }

     public List<ProductEntity> getProduct(int pid) {
          return productDB.getProduct(pid);
     }

     public boolean deleteOne(int pid){
          try{
               productDB.deleteById(pid);
               return true;
          }
          catch(Exception err){
               return false;
          }
     }
}
