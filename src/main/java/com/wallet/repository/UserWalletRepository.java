package com.wallet.repository;

import com.wallet.entity.UserWallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWalletRepository extends JpaRepository<UserWallet,Long> {

    Object findByUsersIdAndWalletId(long user, long wallet);
}
