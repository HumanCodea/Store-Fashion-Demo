package com.example.FashionStore.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.FashionStore.model.Clothes;
import com.example.FashionStore.model.ClothesDTO;
import com.example.FashionStore.model.MyClothes;
import com.example.FashionStore.service.ClothesService;
import com.example.FashionStore.service.MyClothesService;

@Controller
@RequestMapping(path = "")
public class ClothesController {

    @Autowired
    private ClothesService clothesService;

    @Autowired
    private MyClothesService myClothesService;
    
    @GetMapping("/home")
    public String HomeUser(){
        return "homeUser";
    }

    @GetMapping("/homeAdmin")
    public String homeAdmin(){
        return "homeAdmin";
    }

    @GetMapping("/available_clothes")
    public String ListClothes(Model model, @Param("nameClothes") String nameClothes){
        List<Clothes> list = clothesService.getAllClothes();
        if(nameClothes != null){
            list = clothesService.findClothesByName(nameClothes);
            model.addAttribute("nameClothes", nameClothes);
        }
        model.addAttribute("clothes", list);
        return "listClothes";
    }

    @PostMapping("/save")
    public String SaveClothes(@ModelAttribute ClothesDTO clothesDTO){

        MultipartFile image = clothesDTO.getImageFileName();
        String storageFileName = image.getOriginalFilename();

        try{
            String uploadDir = "static/picture/";
            Path uploadPath = Paths.get(uploadDir);

            if(!Files.exists(uploadPath)){
                Files.createDirectories(uploadPath);
            }

            try(InputStream inputStream = image.getInputStream()){
                Files.copy(inputStream, Paths.get(uploadDir + storageFileName),
                    StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception e){
            System.out.println("ExceptionL:" + e.getMessage());
        }

        Clothes clothes = new Clothes();
        clothes.setNameClothes(clothesDTO.getNameClothes());
        clothes.setMaterial(clothesDTO.getMaterial());
        clothes.setColor(clothesDTO.getColor());
        clothes.setSizes(clothesDTO.getSizes());
        clothes.setPrices(clothesDTO.getPrices());
        clothes.setImageFileName(storageFileName);

        clothesService.SaveClothes(clothes);
        return "redirect:/available_clothes";
    }

    @GetMapping("/clothes_register")
    public String RegisterClothes(Model model){
        ClothesDTO clothesDTO = new ClothesDTO();
        model.addAttribute("clothesDto", clothesDTO);
        return "registerClothes";
    }

    @GetMapping("/deleteList/{id}")
    public String DeleteClothes(@PathVariable("id") int id){
        clothesService.DeleteClothesById(id);
        return "redirect:/available_clothes";
    }

    @GetMapping("/editList/{id}")
    public String EditClothes(@PathVariable("id") int id,Model model){
        Clothes clothes = clothesService.findClothesById(id);
        model.addAttribute("clothes", clothes);
        return "editClothes";
    }

    @GetMapping("/mylist/{id}")
    public String AddToMyClothes(@PathVariable("id") int id){
        Clothes clothes = clothesService.findClothesById(id); 
        MyClothes myClothes = new MyClothes(clothes.getId(), clothes.getNameClothes(), clothes.getMaterial(), clothes.getColor(), clothes.getSizes(), clothes.getPrices(), clothes.getImageFileName());
        myClothesService.saveClothes(myClothes);
        return "redirect:/my_clothes";
    }

    @GetMapping("/search_clothes")
    public String SearchClothes(Model model, @Param("nameClothes") String nameClothes){
        List<Clothes> list = clothesService.getAllClothes();
        if(nameClothes != null){
            list = clothesService.findClothesByName(nameClothes);
            model.addAttribute("nameClothes", nameClothes);
        }
        model.addAttribute("clothes", list);
        return "searchClothes";
    }

}
