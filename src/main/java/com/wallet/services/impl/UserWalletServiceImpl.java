package com.wallet.services.impl;

import com.wallet.entity.UserWallet;
import com.wallet.repository.UserWalletRepository;
import com.wallet.services.UserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserWalletServiceImpl implements UserWalletService{

    @Autowired
    UserWalletRepository repo;
    @Override
    public UserWallet save(UserWallet uw){

        return repo.save(uw);
    }

    @Override
    public Object findByUsersIdAndWalletId(long user, long wallet) {
        return repo.findByUsersIdAndWalletId(user, wallet);
    }
}
