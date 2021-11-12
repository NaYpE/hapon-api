package com.hapon.shop.persistence;

import com.hapon.shop.domain.Product;
import com.hapon.shop.domain.repository.ProductRepository;
import com.hapon.shop.persistence.crud.ProductCrudRepository;
import com.hapon.shop.persistence.entity.Producto;
import com.hapon.shop.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    private ProductCrudRepository productCrudRepository;
    private ProductMapper mapper;

    @Override
    public Optional<Product> getProduct(int idProduct){
        return productCrudRepository.findById(idProduct).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productCrudRepository.save(producto));
    }

    @Override
    public List<Product> getAll() {

        List<Producto> productos = (List<Producto>) productCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productCrudRepository.findByIdCategorieOrderByAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos =productCrudRepository.findByStockLessThanAndStatus(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public void delete(int idProduct){
        productCrudRepository.deleteById(idProduct);
    }
}
