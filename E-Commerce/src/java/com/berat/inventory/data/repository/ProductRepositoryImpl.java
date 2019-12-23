package com.berat.inventory.data.repository;

import com.berat.inventory.data.entity.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProductRepositoryImpl implements ProductRepository {

    public EntityManager entityManager;

    public ProductRepositoryImpl() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjectTestPU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void saveProduct(Product product) {
        entityManager.persist(product);
    }

    @Override
    public void deleteProduct(Product product) {
        if (entityManager.contains(product)) {
            entityManager.remove(product);
        } else {
            Product deleteProduct = findProductsById(product.getProductId());
            entityManager.remove(deleteProduct);
        }
    }

    @Override
    public Product updateProduct(Product product) {
        Product updatedProduct = entityManager.merge(product);
        return updatedProduct;
    }

    @Override
    public Product findProductsById(long productId) {
        return entityManager.createQuery("SELECT p FROM Product p WHERE p.productId = :productId", Product.class)
                .setParameter("productId", productId).getSingleResult();
    }

    @Override
    public List<Product> findAllProducts() {
        return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

}
