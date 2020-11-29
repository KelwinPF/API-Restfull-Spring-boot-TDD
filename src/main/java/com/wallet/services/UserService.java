package com.wallet.services;

import com.wallet.entity.User;

import java.util.Optional;

public interface UserService {

    User save(User u);
    Optional<User> findByEmail(String email);
}
