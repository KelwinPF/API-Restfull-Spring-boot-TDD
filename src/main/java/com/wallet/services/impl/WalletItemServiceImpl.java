package com.wallet.services.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.wallet.services.WalletItemService;
import com.wallet.util.TypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.wallet.entity.WalletItem;
import com.wallet.repository.WalletItemRepository;


@Service
public class WalletItemServiceImpl implements WalletItemService {

    @Autowired
    WalletItemRepository repository;

    @Override
    @CacheEvict(value = "findByWalletAndType", allEntries = true)
    public WalletItem save(WalletItem i) {
        return repository.save(i);
    }

    @Override
    public Page<WalletItem> findBetweenDates(Long wallet, Date start, Date end, int page,int itemsPerPage) {

        @SuppressWarnings("deprecation")
        PageRequest pg = PageRequest.of(page, itemsPerPage);

        return repository.findAllByWalletIdAndDateGreaterThanEqualAndDateLessThanEqual(wallet, start, end, pg,itemsPerPage);
    }

    @Override
    @Cacheable(value = "findByWalletAndType")
    public List<WalletItem> findByWalletAndType(Long wallet, TypeEnum type) {
        return repository.findByWalletIdAndType(wallet, type);
    }

    @Override
    public BigDecimal sumByWalletId(Long wallet) {
        return repository.sumByWalletId(wallet);
    }

    @Override
    public Optional<WalletItem> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @CacheEvict(value = "findByWalletAndType", allEntries = true)
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}

