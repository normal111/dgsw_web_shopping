package kr.hs.dgsw.shopping_back.Repository;

import kr.hs.dgsw.shopping_back.Domain.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

}
