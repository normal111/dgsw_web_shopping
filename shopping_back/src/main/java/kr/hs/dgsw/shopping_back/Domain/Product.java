package kr.hs.dgsw.shopping_back.Domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
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
    // created?
}
