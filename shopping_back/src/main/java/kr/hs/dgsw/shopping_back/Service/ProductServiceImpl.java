package kr.hs.dgsw.shopping_back.Service;

import kr.hs.dgsw.shopping_back.Domain.Product;
import kr.hs.dgsw.shopping_back.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> selectProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product selectProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product insetProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.findById(product.getId())
                .map(found -> {
                    found.setName(Optional.ofNullable(product.getName()).orElse(found.getName()));
                    found.setPrice(Optional.ofNullable(product.getPrice()).orElse(found.getPrice()));
                    found.setImage(Optional.ofNullable(product.getImage()).orElse(found.getImage()));
                    found.setCompany(Optional.ofNullable(product.getCompany()).orElse(found.getCompany()));
                    found.setCategory_id(Optional.ofNullable(product.getCategory_id()).orElse(found.getCategory_id()));
                    found.setSub_category(Optional.ofNullable(product.getSub_category()).orElse(found.getSub_category()));
                    found.setMileage(Optional.ofNullable(product.getMileage()).orElse(found.getMileage()));
                    found.setContent(Optional.ofNullable(product.getContent()).orElse(found.getContent()));
                    found.setDetail(Optional.ofNullable(product.getDetail()).orElse(found.getDetail()));
                    found.setPur_info(Optional.ofNullable(product.getPur_info()).orElse(found.getPur_info()));
                    return found;
                })
                .orElse(null);
    }

    @Override
    public boolean deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
