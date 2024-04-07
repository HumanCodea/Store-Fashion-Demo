package com.example.FashionStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FashionStore.model.MyClothes;
import com.example.FashionStore.repositories.MyClothesRepository;

@Service
public class MyClothesService {
    
    @Autowired
    private MyClothesRepository myClothesRepository;

    public List<MyClothes> getAllMyClothes(){
        return myClothesRepository.findAll();
    }

    public List<MyClothes> findClothesByName(String nameClothes){
        return myClothesRepository.findClothesByName(nameClothes);
    }

    public MyClothes findClothesById(int id){
        return myClothesRepository.findById(id).get();
    }

    public void saveClothes(MyClothes myClothes){
        myClothesRepository.save(myClothes);
    }

    public void deleteClothes(int id){
        myClothesRepository.deleteById(id);
    }

}
