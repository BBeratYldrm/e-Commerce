package com.berat.inventory.presentation.faces;

import com.berat.inventory.data.entity.Product;
import com.berat.inventory.data.repository.ProductRepository;
import com.berat.inventory.data.repository.ProductRepositoryImpl;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ProductListBean {

    private List<Product> productList;

    public ProductListBean() throws Exception {
        ProductRepository productRepository = new ProductRepositoryImpl();
        productList = productRepository.findAllProducts();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

}
