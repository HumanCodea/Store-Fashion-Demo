package com.example.FashionStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.FashionStore.model.Custormer;
import com.example.FashionStore.service.CustormerService;

@Controller
@RequestMapping(path = "")
public class CustormerController {
    
    @Autowired
    private CustormerService custormerService;

    @GetMapping("/login")
    public String PageLogin(){
        return "loginUser";
    }

    @GetMapping("/register")
    public String PageRegister(){
        return "registerUser";
    }

    @PostMapping("/saveUser")
    public String SaveCustormer(@ModelAttribute Custormer custormer){
        custormerService.SaveCustormer(custormer);
        return "redirect:/register?successfully";
    }

    @GetMapping("logout")
    public String LogoutPage(){
        return "loginUser";
    }

    @GetMapping("/infor")
    public String Infor(){
        return "inforUser";
    }

}
