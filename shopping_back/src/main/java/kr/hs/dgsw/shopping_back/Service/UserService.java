package kr.hs.dgsw.shopping_back.Service;

import kr.hs.dgsw.shopping_back.Domain.User;

import java.util.List;

public interface UserService {
    List<User> selectUser();

    User selectUser(String id);

    User loginUser(User user);

    User insetUser(User user);

    User updateUser(User user);

    boolean deleteUser(String id);
}
