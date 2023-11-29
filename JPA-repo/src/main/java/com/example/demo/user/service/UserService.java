package com.example.demo.user.service;


import com.example.demo.exception.DataNotFoundException;
import com.example.demo.user.entity.UserAccount;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserAccount create(String username, String email, String password) {
        UserAccount user = new UserAccount();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        this.userRepository.save(user);
        return user;
    }

    public UserAccount getUser(String username){
        Optional<UserAccount> userAccount = this.userRepository.findByUsername(username);
        if(userAccount.isPresent()){
            return userAccount.get();
        }else {
            throw new DataNotFoundException("userAccount not found");
        }
    }

}
