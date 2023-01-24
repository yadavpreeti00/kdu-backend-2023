package com.preeti.spring4.repository;

import com.preeti.spring4.entity.User;
import com.preeti.spring4.enums.Role;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserRepository {

    List<User> userRepository=new ArrayList<>();

    @PostConstruct
    public void generateUser()
    {
        for (int i = 0; i < 10; i++)
        {
            User user = new User( "John" + i, "Doe" + i, "johndoe" + i + "@example.com","Pa$$w0rd" + i, (i % 2 == 0) ? Role.BASIC : Role.ADMIN);
            userRepository.add(user);
        }
        //logger.info("UserCreated");
    }

    public Optional<User> findByName(String username)
    {
        return userRepository.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();

    }

    public void addUser(User user)
    {
        userRepository.add(user);
    }

    public int getSize()
    {
        System.out.println(userRepository.size());
        return userRepository.size();
    }

    public Optional<User> findByEmail(String email)
    {
        return userRepository.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    public List<User> getAll()
    {
        return userRepository;
    }


}
