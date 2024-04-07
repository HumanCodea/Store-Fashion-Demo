package com.example.FashionStore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class MyClothes {
    @Id
    private int id;
    @Column(name = "name_clothes")
    private String nameClothes;
    private String material;
    private String color;
    private String sizes;
    private int prices;

    public MyClothes() {
    }

    public MyClothes(int id, String nameClothes, String material, String color, String sizes, int prices) {
        this.id = id;
        this.nameClothes = nameClothes;
        this.material = material;
        this.color = color;
        this.sizes = sizes;
        this.prices = prices;
    }

}
