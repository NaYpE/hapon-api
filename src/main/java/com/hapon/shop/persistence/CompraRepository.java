package com.hapon.shop.persistence;

import com.hapon.shop.domain.PurchaseDom;
import com.hapon.shop.domain.repository.PurchaseRepository;
import com.hapon.shop.persistence.crud.CompraCrudRepository;
import com.hapon.shop.persistence.entity.Purchase;
import com.hapon.shop.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public List<PurchaseDom> getAll() {
        return purchaseMapper.toPurchases((List<Purchase>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<PurchaseDom>> getByClient(String clientId) {
        return compraCrudRepository.findByIdClient(clientId)
                .map(purchases -> purchaseMapper.toPurchases(purchases));
    }

    @Override
    public PurchaseDom save(PurchaseDom purchaseDom) {
        Purchase purchase = purchaseMapper.toPurchaseEntity(purchaseDom);
        purchase.getProductos().forEach(product -> product.setPurchase(purchase));

        return purchaseMapper.toPurchaseDom(compraCrudRepository.save(purchase));
    }
}
