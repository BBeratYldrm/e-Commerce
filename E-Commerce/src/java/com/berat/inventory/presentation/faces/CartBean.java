package com.berat.inventory.presentation.faces;

import com.berat.inventory.data.entity.Cart;
import com.berat.inventory.data.entity.CartProduct;
import com.berat.inventory.data.entity.Product;
import com.berat.inventory.data.repository.CartRepository;
import com.berat.inventory.data.repository.CartRepositoryImpl;
import com.berat.inventory.data.repository.ProductRepositoryImpl;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
public class CartBean {

    private Cart cart;

    public CartBean() {
        cart = new Cart();
        cart.setCardProductList(new ArrayList<>());
    }

    public void add() {
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequest();

        long productId = Long.parseLong(request.getParameter("productId"));
        Product product = new ProductRepositoryImpl().findProductsById(productId);
        CartProduct cartProduct = new CartProduct();
        cartProduct.setProduct(product);
        cartProduct.setCart(cart);
        cart.getCardProductList().add(cartProduct);

    }

    public void checkOut() {
        CartRepository cartRepository = new CartRepositoryImpl();
        cartRepository.persist(cart);

    }

    public Cart getCart() {
        return cart;
    }

}
