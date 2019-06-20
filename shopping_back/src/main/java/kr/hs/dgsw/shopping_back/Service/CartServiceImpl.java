package kr.hs.dgsw.shopping_back.Service;

import kr.hs.dgsw.shopping_back.Domain.Cart;
import kr.hs.dgsw.shopping_back.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
