package kr.hs.dgsw.shopping_back.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String password;
    private String name;
    private String phone;
    private String mobile;
    private String postal_code;
    private String address;
    private String email;
    @CreationTimestamp
    private LocalDateTime created;

    public User(String id, String password, String name, String phone, String mobile, String postal_code, String address, String email) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.mobile = mobile;
        this.postal_code = postal_code;
        this.address = address;
        this.email = email;
    }
}
