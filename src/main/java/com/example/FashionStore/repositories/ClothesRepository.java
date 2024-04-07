package com.example.FashionStore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.FashionStore.model.Clothes;

@Repository
public interface ClothesRepository extends JpaRepository<Clothes, Integer>{

    @Query("Select c From Clothes c Where c.nameClothes Like %?1%")
    public List<Clothes> findClothesByName(String nameClothes);

}
