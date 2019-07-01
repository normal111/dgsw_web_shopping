package kr.hs.dgsw.shopping_back.Service;

import kr.hs.dgsw.shopping_back.Domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> selectProduct();

    Product selectProduct(Long id);

    List<Product> selectCategory(Long category_id);

    Product insetProduct(Product product);

    Product updateProduct(Product product);

    boolean deleteProduct(Long id);
}
