package com.hapon.shop.persistence.mapper;

import com.hapon.shop.domain.PurchaseDom;
import com.hapon.shop.persistence.entity.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idPurchase", target = "purchaseId"),
            @Mapping(source = "idClient", target = "clientId"),
            @Mapping(source = "status", target = "state"),
            @Mapping(source = "productos", target = "item")
    })
    PurchaseDom toPurchaseDom(Purchase purchaseEntity);
    List<PurchaseDom> toPurchases(List<Purchase> purchases);

    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    Purchase toPurchaseEntity(PurchaseDom purchaseDom);
}
