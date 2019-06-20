package kr.hs.dgsw.shopping_back.Service;

import kr.hs.dgsw.shopping_back.Domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> selectCategory();

    Category selectCategory(Long id);

    Category insetCategory(Category category);

    Category updateCategory(Category category);

    boolean deleteCategory(Long id);
}
