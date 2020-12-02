package com.wallet.services.impl;

import com.wallet.repository.UserRepository;
import com.wallet.entity.User;
import com.wallet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository repo;

    @Override
    public User save(User u){
        return repo.save(u);
    }

    @Override
    public Optional<User> findByEmail(String email){
        return repo.findByEmail(email);
    }
}
