package com.wallet.services;

import com.wallet.entity.UserWallet;

public interface UserWalletService {
    UserWallet save(UserWallet uw);

    Object findByUsersIdAndWalletId(long user, long wallet);
}
