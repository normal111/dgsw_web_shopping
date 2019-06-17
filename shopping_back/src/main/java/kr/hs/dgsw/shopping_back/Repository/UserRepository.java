package kr.hs.dgsw.shopping_back.Repository;

import kr.hs.dgsw.shopping_back.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{

}
