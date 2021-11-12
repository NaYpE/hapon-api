package com.hapon.shop.persistence.mapper;

import com.hapon.shop.domain.Product;
import com.hapon.shop.persistence.entity.Producto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProduct", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "idCategorie", target = "categoryId"),
            @Mapping(source = "salePrice", target = "price"),
            @Mapping(source = "stock", target = "stock"),
            @Mapping(source = "status", target = "active"),
            @Mapping(source = "categorie", target = "category"),
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target = "barcode", ignore = true)
    Producto toProducto(Product product);
}
