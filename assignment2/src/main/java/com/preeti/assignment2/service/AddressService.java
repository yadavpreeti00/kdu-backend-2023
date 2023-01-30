package com.preeti.assignment2.service;

import com.preeti.assignment2.entity.Address;
import com.preeti.assignment2.entity.User;
import com.preeti.assignment2.exception.AddressNotFoundException;
import com.preeti.assignment2.repository.IAddressRepository;
import com.preeti.assignment2.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    IAddressRepository addressRepository;
    @Autowired
    IUserRepository userRepository;

    public Address createAddress(Address address) {
        User user=address.getUser();
        address.setUser(userRepository.getReferenceById(user.getUsername()));

        return addressRepository.save(address);
    }

    public List<Address> findAllAddressesByUserUsername(String username) {

        if(!userRepository.existsById(username))
        {
            throw new UsernameNotFoundException(username);
        }
        List<Address> addresses = addressRepository.findAllByUserUsername(username);
        return addresses;
    }

    public Address getAddressByTag(String addressTag) {
        return  addressRepository.findById(addressTag).orElseThrow(() -> new AddressNotFoundException(addressTag));
    }
}
