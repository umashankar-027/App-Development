package com.techbasket.techbasket.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techbasket.techbasket.entity.ProductEntity;
import com.techbasket.techbasket.entity.SearchEntity;
import com.techbasket.techbasket.service.ProductService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequiredArgsConstructor
public class ProductController {

     private final ProductService pService;

     @GetMapping("/getMostIntrested")
     public List<ProductEntity> getMostIn() {
          return pService.getMostIn();
     }

     @PostMapping(value = "/searchThis")
     public List<ProductEntity> searchThis(@RequestBody SearchEntity entity) {

          return pService.findSearch(entity.getName(), entity.getPage());
     }

     @GetMapping(value = "/searchThisCount")
     public long searchThisCount(@RequestParam String name) {

          return pService.getTotalOf(name);
     }

     @GetMapping("/getMostRecent")
     public List<ProductEntity> getMostRecent() {
          return pService.getMostRe();
     }

     @GetMapping("/getProduct")
     public List<ProductEntity> getProduct(@RequestParam int pid) {
          return pService.getProduct(pid);
     }

     @GetMapping("/getRelPrd")
     public List<ProductEntity> getRelPrd(@RequestParam String prd) {
          return pService.findSearch(prd, 1);
     }
}
