package kr.hs.dgsw.shopping_back.Service;

import kr.hs.dgsw.shopping_back.Domain.Cart;

import java.util.List;

public interface CartService {
    List<Cart> selectCart();

    Cart selectCart(Long id);

    Cart insetCart(Cart cart);

    Cart updateCart(Cart cart);

    boolean deleteCart(Long id);
}
