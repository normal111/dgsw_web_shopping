package kr.hs.dgsw.shopping_back.Service;

import kr.hs.dgsw.shopping_back.Domain.Purchase;

import java.util.List;

public interface PurchaseService {
    List<Purchase> selectPurchase();

    Purchase selectPurchase(Long id);

    Purchase insetPurchase(Purchase purchase);

    Purchase updatePurchase(Purchase purchase);

    boolean deletePurchase(Long id);
}
