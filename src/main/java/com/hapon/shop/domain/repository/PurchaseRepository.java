package com.hapon.shop.domain.repository;

import com.hapon.shop.domain.PurchaseDom;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<PurchaseDom> getAll();
    Optional<List<PurchaseDom>> getByClient(String clientId);
    PurchaseDom save(PurchaseDom purchase);
}
