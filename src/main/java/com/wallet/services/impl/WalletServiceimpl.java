package com.wallet.services.impl;

import com.wallet.entity.Wallet;
import com.wallet.repository.WalletRepository;
import com.wallet.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceimpl implements WalletService {
    @Autowired
    private WalletRepository repo;

    @Override
    public Wallet save(Wallet w){
        return repo.save(w);
    }
}
