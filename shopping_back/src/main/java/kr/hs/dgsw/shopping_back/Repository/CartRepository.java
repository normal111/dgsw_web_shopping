package kr.hs.dgsw.shopping_back.Repository;

import kr.hs.dgsw.shopping_back.Domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
