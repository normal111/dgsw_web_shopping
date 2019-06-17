package kr.hs.dgsw.shopping_back.Domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
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
    private Long created;
}
