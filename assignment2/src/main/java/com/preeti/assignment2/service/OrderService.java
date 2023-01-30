package com.preeti.assignment2.service;

import com.preeti.assignment2.entity.*;
import com.preeti.assignment2.exception.BadRequestException;
import com.preeti.assignment2.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class OrderService {

    @Autowired
    ICartRepository cartRepository;
    @Autowired
    IProductRepository productRepository;
    @Autowired
    IOrderRepository orderRepository;
    @Autowired
    IUserRepository userRepository;
    @Autowired
    IAddressRepository addressRepository;

    @Transactional
    public Order placeOrder(Order orderRequest)
    {

        Cart cart = cartRepository.getReferenceById(orderRequest.getCart().getId());
        Address address=addressRepository.getReferenceById(orderRequest.getDeliverAddressTag());
        User user=cart.getUser();




        Product product = productRepository.getReferenceById(orderRequest.getProduct().getId());
        if(orderRequest.getQuantity()>product.getQuantity())
        {
            throw new BadRequestException(orderRequest.getQuantity());
        }

        product.setQuantity(product.getQuantity()- orderRequest.getQuantity());
        productRepository.save(product);


        Order order = new Order();
        order.setUser(user);
        order.setProduct(product);
        order.setQuantity(order.getQuantity());
        order.setDeliverAddressTag(address.getAddressTag());

        return orderRepository.save(order);
    }

    public List<Order> findAllOrdersByUserUsername(String username) {
        if(!userRepository.existsById(username))
        {
            throw new UsernameNotFoundException(username);
        }
        List<Order>orders=orderRepository.findAllByUserUsername(username);
        return orders;

    }
}
