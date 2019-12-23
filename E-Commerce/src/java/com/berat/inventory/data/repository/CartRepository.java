
package com.berat.inventory.data.repository;

import com.berat.inventory.data.entity.Cart;


public interface CartRepository {

    void persist(Cart cart);
}
