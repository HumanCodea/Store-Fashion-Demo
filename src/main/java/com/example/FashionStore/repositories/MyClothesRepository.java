package com.example.FashionStore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.FashionStore.model.MyClothes;

@Repository
public interface MyClothesRepository extends JpaRepository<MyClothes, Integer>{
    
    @Query("Select c From MyClothes c Where c.nameClothes Like %?1%")
    public List<MyClothes> findClothesByName(String nameClothes);

}
