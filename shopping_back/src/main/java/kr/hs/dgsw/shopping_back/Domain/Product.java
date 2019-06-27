package kr.hs.dgsw.shopping_back.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    private String image;
    private String company;
    private Long category_id;
    private String sub_category;
    private int mileage;
    private String content;
    private String detail;
    private String pur_info;
    @CreationTimestamp
    private LocalDateTime created;

    public Product(String name, int price, String image, String company, Long category_id, String sub_category, int mileage, String content, String detail, String pur_info) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.company = company;
        this.category_id = category_id;
        this.sub_category = sub_category;
        this.mileage = mileage;
        this.content = content;
        this.detail = detail;
        this.pur_info = pur_info;
    }
}
