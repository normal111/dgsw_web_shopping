package kr.hs.dgsw.shopping_back.Controller;

import kr.hs.dgsw.shopping_back.Domain.Cart;
import kr.hs.dgsw.shopping_back.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/select")
    public List<Cart> selectCart() {
        return cartService.selectCart();
    }

    @GetMapping("/select/{id}")
    public Cart selectCart(@PathVariable Long id) {
        return cartService.selectCart(id);
    }

    @GetMapping("/get/{user_id}")
    public List<Cart> getCart(@PathVariable String user_id) {
        return cartService.getCart(user_id);
    }

    @PostMapping("/insert")
    public Cart selectCart(@RequestBody Cart cart) {
        return cartService.insetCart(cart);
    }

    @PutMapping("/update")
    public Cart updateCart(@RequestBody Cart cart) {
        return cartService.updateCart(cart);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean updateCart(@PathVariable Long id) {
        return cartService.deleteCart(id);
    }

}
