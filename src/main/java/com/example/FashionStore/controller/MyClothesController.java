package com.example.FashionStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.FashionStore.model.MyClothes;
import com.example.FashionStore.service.MyClothesService;


@Controller
@RequestMapping(path = "")
public class MyClothesController {

    @Autowired
    private MyClothesService myClothesService;
    
    @GetMapping("/my_clothes")
    public String ListMyClothes(Model model, @Param("nameClothes") String nameClothes){
        List<MyClothes> list = myClothesService.getAllMyClothes();
        if(nameClothes != null){
            list = myClothesService.findClothesByName(nameClothes);
            model.addAttribute("nameClothes", nameClothes);
        }
        model.addAttribute("clothes", list);
        return "myClothes";
    }

    @GetMapping("/deleteMyList/{id}")
    public String deleteClothes(@PathVariable("id") int id){
        myClothesService.deleteClothes(id);
        return "redirect:/my_clothes";
    }

}
