package kr.hs.dgsw.shopping_back.Controller;

import kr.hs.dgsw.shopping_back.Domain.Category;
import kr.hs.dgsw.shopping_back.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/select")
    public List<Category> selectCategory() {
        return categoryService.selectCategory();
    }

    @GetMapping("/select/{id}")
    public Category selectCategory(@PathVariable Long id) {
        return categoryService.selectCategory(id);
    }

    @PostMapping("/insert")
    public Category selectCategory(@RequestBody Category category) {
        return categoryService.insetCategory(category);
    }

    @PutMapping("/update")
    public Category updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean updateCategory(@PathVariable Long id) {
        return categoryService.deleteCategory(id);
    }

}
