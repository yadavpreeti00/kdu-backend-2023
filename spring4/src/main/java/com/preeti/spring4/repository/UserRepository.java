package com.preeti.spring4.repository;

import com.preeti.spring4.entity.User;
import com.preeti.spring4.enums.Role;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.preeti.spring4.enums.Role.ADMIN;


@Component
public class UserRepository {

    List<User> userRepository=new ArrayList<>();


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
        return userRepository.size();
    }

    public Optional<User> findByEmail(String email)
    {
        return userRepository.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    public User findByFirstName(String name) {
        Optional<User> user = userRepository.stream()
                .filter(u -> u.getFirstname().equals(name))
                .findFirst();
        if (!user.isPresent()) {
            throw new RuntimeException("User not found");
        }
        return user.get();
    }

    public List<User> getAll()
    {
        return userRepository;
    }


}
