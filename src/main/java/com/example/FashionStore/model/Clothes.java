package com.example.FashionStore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Clothes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name_clothes")
    private String nameClothes;
    private String material;
    private String color;
    private String sizes;
    private int prices;

    public Clothes() {
    }

    public Clothes(String nameClothes, String material, String color, String sizes, int prices) {
        this.nameClothes = nameClothes;
        this.material = material;
        this.color = color;
        this.sizes = sizes;
        this.prices = prices;
    }

}
