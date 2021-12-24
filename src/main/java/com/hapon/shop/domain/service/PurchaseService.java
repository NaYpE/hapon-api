package com.hapon.shop.domain.service;

import com.hapon.shop.domain.PurchaseDom;
import com.hapon.shop.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<PurchaseDom> getAll() {
        return purchaseRepository.getAll();
    }

    public Optional<List<PurchaseDom>> getByClient(String clientId) {
        return purchaseRepository.getByClient(clientId);
    }

    public PurchaseDom save(PurchaseDom purchase) {
        return purchaseRepository.save(purchase);
    }
}