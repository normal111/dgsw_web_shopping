package kr.hs.dgsw.shopping_back.Controller;

import kr.hs.dgsw.shopping_back.Domain.Product;
import kr.hs.dgsw.shopping_back.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/select")
    public List<Product> selectProduct() {
        return productService.selectProduct();
    }

    @GetMapping("/select/{id}")
    public Product selectProduct(@PathVariable Long id) {
        return productService.selectProduct(id);
    }

    @PostMapping("/insert")
    public Product selectProduct(@RequestBody Product product) {
        return productService.insetProduct(product);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean updateProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }

}
