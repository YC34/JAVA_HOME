package com.example.demo.user.repository;


import com.example.demo.user.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserAccount,Long> {


    Optional<UserAccount> findByUsername(String username);
}
