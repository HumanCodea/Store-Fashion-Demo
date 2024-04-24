package com.example.FashionStore.model;

import org.springframework.web.multipart.MultipartFile;

public class ClothesDTO {
    
    private int id;
    private String nameClothes;
    private String material;
    private String color;
    private String sizes;
    private int prices;
    private MultipartFile imageFileName;

    public ClothesDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameClothes() {
        return nameClothes;
    }

    public void setNameClothes(String nameClothes) {
        this.nameClothes = nameClothes;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public int getPrices() {
        return prices;
    }

    public void setPrices(int prices) {
        this.prices = prices;
    }

    public MultipartFile getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(MultipartFile imageFileName) {
        this.imageFileName = imageFileName;
    }

   
}
