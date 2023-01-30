package com.preeti.assignment2.service;

import com.preeti.assignment2.entity.Address;
import com.preeti.assignment2.entity.Order;
import com.preeti.assignment2.entity.Product;
import com.preeti.assignment2.entity.User;
import com.preeti.assignment2.exception.AddressNotFoundException;
import com.preeti.assignment2.repository.IAddressRepository;
import com.preeti.assignment2.repository.IUserRepository;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;
    @Autowired
    AddressService addressService;

    public User createUser(User user)
    {
        return userRepository.save(user);
    }


}
