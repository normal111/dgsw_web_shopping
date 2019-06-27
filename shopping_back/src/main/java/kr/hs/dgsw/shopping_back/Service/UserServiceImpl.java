package kr.hs.dgsw.shopping_back.Service;

import kr.hs.dgsw.shopping_back.Domain.Category;
import kr.hs.dgsw.shopping_back.Domain.Product;
import kr.hs.dgsw.shopping_back.Domain.User;
import kr.hs.dgsw.shopping_back.Repository.CategoryRepository;
import kr.hs.dgsw.shopping_back.Repository.ProductRepository;
import kr.hs.dgsw.shopping_back.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @PostConstruct
    private void init() {
        User user = this.userRepository.save(new User("abc", "abc", "user1", "010", "010", "50146", "대소고", "이메일"));

        this.categoryRepository.save(new Category("상의(남)"));
        this.categoryRepository.save(new Category("하의(남)"));
        this.categoryRepository.save(new Category("상의(여)"));
        this.categoryRepository.save(new Category("하의(여)"));
        this.categoryRepository.save(new Category("구두"));
        this.categoryRepository.save(new Category("가방"));
        this.categoryRepository.save(new Category("소품"));

        Long bagId = categoryRepository.findByName("가방").get().getId();
        this.productRepository.save(new Product("고급가방", 1000, "D:\\Other\\Project\\IntelliJ\\web_shopping\\shopping_back\\upload\\다이아백.jpg", "대소고", bagId, "크로스백", 10, "고오오오오급 가압입니다", "고오오오오급 가압입니다", "구매정보"));
    }

    @Override
    public List<User> selectUser() {
        return userRepository.findAll();
    }

    @Override
    public User selectUser(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User loginUser(User user) {
        return userRepository.findByIdAndPassword(user.getId(), user.getPassword()).orElse(null);
    }

    @Override
    public User insetUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.findById(user.getId())
                .map(found -> {
                    found.setPassword(Optional.ofNullable(user.getPassword()).orElse(found.getPassword()));
                    found.setName(Optional.ofNullable(user.getName()).orElse(found.getName()));
                    found.setPhone(Optional.ofNullable(user.getPhone()).orElse(found.getPhone()));
                    found.setMobile(Optional.ofNullable(user.getMobile()).orElse(found.getMobile()));
                    found.setPostal_code(Optional.ofNullable(user.getPostal_code()).orElse(found.getPostal_code()));
                    found.setAddress(Optional.ofNullable(user.getAddress()).orElse(found.getAddress()));
                    found.setEmail(Optional.ofNullable(user.getEmail()).orElse(found.getEmail()));
                    return found;
                })
                .orElse(null);
    }

    @Override
    public boolean deleteUser(String id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
