package com.techbasket.techbasket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import com.techbasket.techbasket.db.CartDb;
import com.techbasket.techbasket.db.ProductDB;
import com.techbasket.techbasket.db.UserDb;
import com.techbasket.techbasket.entity.CartEntity;

@Service
public class CartService {

     @Autowired
     UserDb userDb;
     @Autowired
     CartDb cartDb;
     @Autowired
     ProductDB productDB;

     public List<Object> getCartItems(String username, String password) {
          int uid = userDb.getUserId(username, password);
          return productDB.getCartProducts(uid);
     }

     public boolean addToCart(String username, String password, int pid) {
          try {
               int uid = userDb.getUserId(username, password);
               CartEntity cart = new CartEntity();
               cart.setPid(pid);
               cart.setUid(uid);

               cartDb.save(cart);
               return true;
          } catch (Exception err) {
               return false;
          }
     }

     public boolean deleteFromCart(String username, String password, int pid) {
          try {
               int uid = userDb.getUserId(username, password);
               cartDb.deleteByUidPid(uid, pid);
               return true;
          } catch (Exception err) {
               System.out.println(err);
               return false;
          }
     }
     public boolean deleteFromCartOne(String username, String password, int pid) {
          try {
               int uid = userDb.getUserId(username, password);
               cartDb.deleteByUidPidOne(uid, pid);
               return true;
          } catch (Exception err) {
               System.out.println(err);
               return false;
          }
     }
}
