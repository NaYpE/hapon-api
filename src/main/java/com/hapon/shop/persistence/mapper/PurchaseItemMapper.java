package com.hapon.shop.persistence.mapper;

import com.hapon.shop.domain.PurchaseItem;
import com.hapon.shop.persistence.entity.PurchasesProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProduct", target = "productId"),
            @Mapping(source = "amount", target = "quantity"),
            //no pongo total porque llevan el mismo nombre y se mapean automaticamente
            @Mapping(source = "status", target = "active"),
    })
    PurchaseItem toPurchaseItem(PurchasesProduct product);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchase", ignore = true),
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "id.idPurchase", ignore = true)
    })
    PurchasesProduct toPurchasesProduct (PurchaseItem item);
}
