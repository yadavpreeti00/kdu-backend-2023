package com.preeti.assignment2.service;
import com.preeti.assignment2.entity.Order;
import com.preeti.assignment2.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {


    public List<Product> getAllProductsFromOrder(List<Order> orders) {
        List<Product>products=new ArrayList<>();
        for(Order order:orders)
        {
            products.add(order.getProduct());
        }
        return products;
    }
}
