package com.hapon.shop.persistence.crud;

import com.hapon.shop.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {
    List<Product> findByIdCategorieOrderByAsc(int idCategorie);
    Optional<List<Product>> findByStockLessThanAndStatus(int stock, boolean status);
}
