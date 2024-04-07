package com.example.FashionStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FashionStore.model.Clothes;
import com.example.FashionStore.repositories.ClothesRepository;

@Service
public class ClothesService {

    @Autowired
    private ClothesRepository clothesRepository;

    public List<Clothes> getAllClothes(){
        return clothesRepository.findAll();
    }

    public void SaveClothes(Clothes clothes){
        clothesRepository.save(clothes);
    }

    public void DeleteClothesById(int id){
        clothesRepository.deleteById(id);
    }

    public Clothes findClothesById(int id){
        return clothesRepository.findById(id).get();
    }

    public List<Clothes> findClothesByName(String nameClothes){
        return clothesRepository.findClothesByName(nameClothes);
    }

}
