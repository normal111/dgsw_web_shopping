package kr.hs.dgsw.shopping_back.Service;

import kr.hs.dgsw.shopping_back.Domain.Purchase;
import kr.hs.dgsw.shopping_back.Repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    PurchaseRepository purchaseRepository;

    @Override
    public List<Purchase> selectPurchase() {
        return purchaseRepository.findAll();
    }

    @Override
    public Purchase selectPurchase(Long id) {
        return purchaseRepository.findById(id).orElse(null);
    }

    @Override
    public Purchase insetPurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }


//    private Long Product_id;
//    private String User_id;
//    private int Count;
//    private String State;

    @Override
    public Purchase updatePurchase(Purchase purchase) {
        return purchaseRepository.findById(purchase.getId())
                .map(found -> {
                    found.setProduct_id(Optional.ofNullable(purchase.getProduct_id()).orElse(found.getProduct_id()));
                    found.setUser_id(Optional.ofNullable(purchase.getUser_id()).orElse(found.getUser_id()));
                    found.setCount(Optional.ofNullable(purchase.getCount()).orElse(found.getCount()));
                    found.setState(Optional.ofNullable(purchase.getState()).orElse(found.getState()));
                    return found;
                })
                .orElse(null);
    }

    @Override
    public boolean deletePurchase(Long id) {
        try {
            purchaseRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
