package kr.hs.dgsw.shopping_back.Controller;

import kr.hs.dgsw.shopping_back.Domain.User;
import kr.hs.dgsw.shopping_back.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/select")
    public List<User> selectUser() {
        return userService.selectUser();
    }

    @GetMapping("/select/{id}")
    public User selectUser(@PathVariable String id) {
        return userService.selectUser(id);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) {
        return userService.loginUser(user);
    }

    @PostMapping("/insert")
    public User selectUser(@RequestBody User user) {
        return userService.insetUser(user);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean updateUser(@PathVariable String id) {
        return userService.deleteUser(id);
    }

}
