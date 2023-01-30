package com.preeti.assignment2.controller;

import com.preeti.assignment2.entity.Address;
import com.preeti.assignment2.entity.Order;
import com.preeti.assignment2.entity.Product;
import com.preeti.assignment2.service.OrderService;
import com.preeti.assignment2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    OrderService orderService;

    @GetMapping("/getAll/{username}")
    public ResponseEntity<List<Product>> getAllProducts(@PathVariable String username) {
        List<Order>orders=orderService.findAllOrdersByUserUsername(username);
        List<Product>products=productService.getAllProductsFromOrder(orders);

        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
