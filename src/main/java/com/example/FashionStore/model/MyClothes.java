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
    @Column(name = "image_file_name")
    private String imageFileName;

    public MyClothes() {
    }

    public MyClothes(int id, String nameClothes, String material, String color, String sizes, int prices,
            String imageFileName) {
        this.id = id;
        this.nameClothes = nameClothes;
        this.material = material;
        this.color = color;
        this.sizes = sizes;
        this.prices = prices;
        this.imageFileName = imageFileName;
    }

    

}
