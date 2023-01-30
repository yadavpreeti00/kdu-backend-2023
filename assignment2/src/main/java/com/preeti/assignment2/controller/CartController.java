package com.preeti.assignment2.controller;

import com.preeti.assignment2.entity.Cart;
import com.preeti.assignment2.model.AddProductToCartRequest;
import com.preeti.assignment2.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping
    public ResponseEntity<Cart> addProductToCart(@RequestBody AddProductToCartRequest request) {
        Cart updatedCart = cartService.addProductToCart(request.getUsername(), request.getProductId(),request.getQuantity());
        return new ResponseEntity<>(updatedCart, HttpStatus.OK);
    }

}
