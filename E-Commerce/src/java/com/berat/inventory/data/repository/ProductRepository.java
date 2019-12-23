package com.berat.inventory.data.repository;

import com.berat.inventory.data.entity.Product;
import java.util.List;

public interface ProductRepository {

    void saveProduct(Product product);

    void deleteProduct(Product product);

    Product updateProduct(Product product);

    Product findProductsById(long productId);

    List<Product> findAllProducts() throws Exception;
}
