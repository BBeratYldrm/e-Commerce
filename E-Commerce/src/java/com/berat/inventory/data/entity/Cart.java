package com.berat.inventory.data.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long cartId;

    @Column
    private String customerName;

    @OneToMany(mappedBy = "Cart", cascade = CascadeType.ALL)
    private List<CartProduct> cardProductList;

    public Cart() {
    }

    public Cart(long cartId, String customerName, List<CartProduct> cardProductList) {
        this.cartId = cartId;
        this.customerName = customerName;
        this.cardProductList = cardProductList;

    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<CartProduct> getCardProductList() {
        return cardProductList;
    }

    public void setCardProductList(List<CartProduct> cardProductList) {
        this.cardProductList = cardProductList;
    }

}
