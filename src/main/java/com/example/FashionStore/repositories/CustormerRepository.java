package com.example.FashionStore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FashionStore.model.Custormer;

@Repository
public interface CustormerRepository extends JpaRepository<Custormer, Integer>{

    public List<Custormer> findByUsername(String username);

}
