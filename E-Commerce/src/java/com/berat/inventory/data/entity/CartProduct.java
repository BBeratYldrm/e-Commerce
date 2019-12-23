package com.berat.inventory.data.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CartProduct implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long cartProductId;

    @ManyToOne
    @JoinColumn(name = "Cart_Id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "Product_Id")
    private Product product;

    @Column
    private double salesQuantity;

    public CartProduct() {
    }

    public CartProduct(long cartProductId, Cart cart, Product product, double salesQuantity) {
        this.cartProductId = cartProductId;
        this.cart = cart;
        this.product = product;
        this.salesQuantity = salesQuantity;
    }

    public long getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(long cartProductId) {
        this.cartProductId = cartProductId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(double salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

}
