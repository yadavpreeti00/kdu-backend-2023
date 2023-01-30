package com.preeti.assignment2.service;
import com.preeti.assignment2.entity.Cart;
import com.preeti.assignment2.entity.Product;
import com.preeti.assignment2.exception.ProductNotFoundException;
import com.preeti.assignment2.repository.ICartRepository;
import com.preeti.assignment2.repository.IProductRepository;
import com.preeti.assignment2.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.preeti.assignment2.exception.BadRequestException;

import java.util.UUID;
@Service
public class CartService {

    @Autowired
    IUserRepository userRepository;
    @Autowired
    IProductRepository productRepository;
    @Autowired
    ICartRepository cartRepository;
    public Cart addProductToCart(String username, UUID productId, Integer requestQuantity)
    {
        if(!userRepository.existsById(username))
        {
            throw new UsernameNotFoundException(username);
        }

        Cart cart = cartRepository.findByUserUsername(username);
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId));
        if(requestQuantity>product.getQuantity())
        {
            throw new BadRequestException(requestQuantity);
        }

        cart.getProducts().add(product);
        return cartRepository.save(cart);
    }
}
