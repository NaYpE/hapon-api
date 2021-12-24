package com.hapon.shop.persistence.crud;

import com.hapon.shop.persistence.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Purchase, Integer> {
    Optional<List<Purchase>> findByIdClient(String idClient);
}
