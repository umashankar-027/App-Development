package com.techbasket.techbasket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import com.techbasket.techbasket.entity.AddToCart;
import com.techbasket.techbasket.entity.ProductEntity;
import com.techbasket.techbasket.entity.SearchEntity;
import com.techbasket.techbasket.service.CartService;
import com.techbasket.techbasket.service.ProductService;
import com.techbasket.techbasket.service.UserService;
import com.techbasket.techbasket.util.CookieExtractor;
import com.techbasket.techbasket.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/userspecific")
@RequiredArgsConstructor
public class UserSpecificController {

  @Autowired
  UserService userService;

  private final CookieExtractor cookieExtractor;
  private final JwtUtil jwtUtil;
  private final CartService cartService;
  private final ProductService pService;

  // get from cart
  @GetMapping("/cart")
  public List<Object> cartPrds(@RequestHeader(value = "Cookie") String cookie) {
    String desiredCookie = cookieExtractor.extractCookie(cookie, "user-auth-key");

    String username;
    String password;

    try {
      String credentials[] = jwtUtil
          .extract(desiredCookie)
          .getSubject()
          .split(";");
      username = credentials[0];
      password = credentials[1];
    } catch (Exception err) {
      username = null;
      password = null;
    }

    return cartService.getCartItems(username, password);
  }

  @PostMapping("/addToCart")
  public boolean addToCart(@RequestHeader(value = "Cookie") String cookie, @RequestBody AddToCart cart) {
    String desiredCookie = cookieExtractor.extractCookie(cookie, "user-auth-key");

    String username;
    String password;

    try {
      String credentials[] = jwtUtil
          .extract(desiredCookie)
          .getSubject()
          .split(";");
      username = credentials[0];
      password = credentials[1];
    } catch (Exception err) {
      username = null;
      password = null;
    }
    return cartService.addToCart(username, password, cart.getPid());
  }

  @DeleteMapping("/deleteFromCart")
  public boolean deleteFromCart(@RequestHeader(value = "Cookie") String cookie, @RequestBody AddToCart cart) {
    String desiredCookie = cookieExtractor.extractCookie(cookie, "user-auth-key");

    String username;
    String password;

    try {
      String credentials[] = jwtUtil
          .extract(desiredCookie)
          .getSubject()
          .split(";");
      username = credentials[0];
      password = credentials[1];
    } catch (Exception err) {
      username = null;
      password = null;
    }
    return cartService.deleteFromCart(username, password, cart.getPid());
  }

  @DeleteMapping("/deleteFromCartOne")
  public boolean deleteFromCartOne(@RequestHeader(value = "Cookie") String cookie, @RequestBody AddToCart cart) {
    String desiredCookie = cookieExtractor.extractCookie(cookie, "user-auth-key");

    String username;
    String password;

    try {
      String credentials[] = jwtUtil
          .extract(desiredCookie)
          .getSubject()
          .split(";");
      username = credentials[0];
      password = credentials[1];
    } catch (Exception err) {
      username = null;
      password = null;
    }
    return cartService.deleteFromCartOne(username, password, cart.getPid());
  }

  @GetMapping("/amIaSeller")
  public ResponseEntity<Boolean> amIaSeller(@RequestHeader(value = "Cookie") String cookie) {
    String desiredCookie = cookieExtractor.extractCookie(cookie, "user-auth-key");

    String username;
    String password;

    try {
      String credentials[] = jwtUtil
          .extract(desiredCookie)
          .getSubject()
          .split(";");
      username = credentials[0];
      password = credentials[1];
    } catch (Exception err) {
      username = null;
      password = null;
    }
    return ResponseEntity.ok().body(userService.doesSellerExist(username, password));
  }

  @PostMapping("/addProduct")
  public boolean addProduct(@RequestHeader(value = "Cookie") String cookie, @RequestBody ProductEntity product) {
    String desiredCookie = cookieExtractor.extractCookie(cookie, "user-auth-key");

    String username;
    String password;

    try {
      String credentials[] = jwtUtil
          .extract(desiredCookie)
          .getSubject()
          .split(";");
      username = credentials[0];
      password = credentials[1];
    } catch (Exception err) {
      username = null;
      password = null;
    }
    return userService.addProduct(username, password, product);
  }

  @PostMapping("/thisSellerProducts")
  public List<ProductEntity> thisSellerProducts(@RequestHeader String cookie, @RequestBody SearchEntity se) {
    String desiredCookie = cookieExtractor.extractCookie(cookie, "user-auth-key");

    String username;
    String password;

    try {
      String credentials[] = jwtUtil
          .extract(desiredCookie)
          .getSubject()
          .split(";");
      username = credentials[0];
      password = credentials[1];
    } catch (Exception err) {
      username = null;
      password = null;
    }
    return userService.thisSellerProducts(username, password, se.getPage());

  }

  @GetMapping("/getSellerProductsCount")
  public int getSellerProductsCount(@RequestHeader String cookie) {
    String desiredCookie = cookieExtractor.extractCookie(cookie, "user-auth-key");

    String username;
    String password;

    try {
      String credentials[] = jwtUtil
          .extract(desiredCookie)
          .getSubject()
          .split(";");
      username = credentials[0];
      password = credentials[1];
    } catch (Exception err) {
      username = null;
      password = null;
    }
    return userService.getSellerProductsCount(username, password);

  }

  // only getting specific value(id)
  @DeleteMapping("/deleteOnePrd")
  public boolean deleteOnePrd(@RequestHeader String cookie, @RequestBody ProductEntity e) {
    String desiredCookie = cookieExtractor.extractCookie(cookie, "user-auth-key");

    String username;
    String password;

    try {
      String credentials[] = jwtUtil
          .extract(desiredCookie)
          .getSubject()
          .split(";");
      username = credentials[0];
      password = credentials[1];
    } catch (Exception err) {
      username = null;
      password = null;
    }
    if (username == null || password == null)
      return false;
    return pService.deleteOne(e.getPid());

  }

}
