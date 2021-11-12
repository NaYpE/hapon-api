package com.hapon.shop.persistence;

import com.hapon.shop.persistence.crud.ProductCrudRepository;
import com.hapon.shop.persistence.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private ProductCrudRepository productCrudRepository;

    public Optional<Product> getProduct(int idProduct){
        return productCrudRepository.findById(idProduct);
    }

    public List<Product> getAll() {
        return (List<Product>) productCrudRepository.findAll();
    }

    public List<Product> getByCategorie(int idCategorie) {
        return productCrudRepository.findByIdCategorieOrderByAsc(idCategorie);
    }

    public Optional<List<Product>> getScarceProducts(int stock){
        return productCrudRepository.findByStockLessThanAndStatus(stock, true);
    }

    public Product save(Product product){
        return productCrudRepository.save(product);
    }

    public void delete(int idProduct){
        productCrudRepository.deleteById(idProduct);
    }
}
