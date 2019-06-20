package kr.hs.dgsw.shopping_back.Service;

import kr.hs.dgsw.shopping_back.Domain.User;
import kr.hs.dgsw.shopping_back.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> selectUser() {
        return userRepository.findAll();
    }

    @Override
    public User selectUser(String id) {
        return userRepository.findById(id).orElse(null);
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
        try{
            userRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
