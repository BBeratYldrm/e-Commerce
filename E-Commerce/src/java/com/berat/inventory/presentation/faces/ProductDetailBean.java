package com.berat.inventory.presentation.faces;

import com.berat.inventory.data.entity.Product;
import com.berat.inventory.data.repository.ProductRepositoryImpl;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@RequestScoped
public class ProductDetailBean {

    private Product product;

    public ProductDetailBean() {

        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequest();

        if (request.getParameter("productId") != null) {
            long productId = Long.parseLong(request.getParameter("productId"));

            product = new ProductRepositoryImpl().findProductsById(productId);
        }
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
