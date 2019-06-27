package kr.hs.dgsw.shopping_back.Service;

import kr.hs.dgsw.shopping_back.Domain.Category;
import kr.hs.dgsw.shopping_back.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> selectCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category selectCategory(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category insetCategory(Category category) {
        try {
            return categoryRepository.save(category);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.findById(category.getId())
                .map(found -> {
                    found.setName(Optional.ofNullable(category.getName()).orElse(found.getName()));
                    return found;
                })
                .orElse(null);
    }

    @Override
    public boolean deleteCategory(Long id) {
        try {
            categoryRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
