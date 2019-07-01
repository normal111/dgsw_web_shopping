package kr.hs.dgsw.shopping_back.Service;

import kr.hs.dgsw.shopping_back.Domain.Cart;
import kr.hs.dgsw.shopping_back.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;

    @Override
    public List<Cart> selectCart() {
        return cartRepository.findAll();
    }

    @Override
    public Cart selectCart(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cart> getCart(String user_id) {
        List<Cart> return_carts = new ArrayList<>();
        List<Cart> select_carts = selectCart();
        for (int i = 0; i < select_carts.size(); i++) {
            if (select_carts.get(i).getUser_id().equals(user_id))
                return_carts.add(select_carts.get(i));
        }
        return return_carts;
    }

    @Override
    public Cart insetCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart updateCart(Cart cart) {
        return cartRepository.findById(cart.getId())
                .map(found -> {
                    found.setProduct_id(Optional.ofNullable(cart.getProduct_id()).orElse(found.getProduct_id()));
                    found.setUser_id(Optional.ofNullable(cart.getUser_id()).orElse(found.getUser_id()));
                    found.setCount(Optional.ofNullable(cart.getCount()).orElse(found.getCount()));
                    return found;
                })
                .orElse(null);
    }

    @Override
    public boolean deleteCart(Long id) {
        try {
            cartRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean paymentAllCart(String user_id) {
        try {
            List<Cart> select_carts = selectCart();
            for (int i = 0; i < select_carts.size(); i++) {
                if (select_carts.get(i).getUser_id().equals(user_id)) {
                    //TODO: 여기서 카트->결제로
                    deleteCart(select_carts.get(i).getId());
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
