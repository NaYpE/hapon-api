package com.hapon.shop.persistence.crud;

import com.hapon.shop.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Producto, Integer> {
    List<Producto> findByIdCategorieOrderByAsc(int idCategorie);
    Optional<List<Producto>> findByStockLessThanAndStatus(int stock, boolean status);
}
