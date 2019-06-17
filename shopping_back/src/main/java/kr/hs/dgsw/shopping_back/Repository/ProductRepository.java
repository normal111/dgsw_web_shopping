package kr.hs.dgsw.shopping_back.Repository;

import kr.hs.dgsw.shopping_back.Domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
