package com.driverssea.controllers;

import com.driverssea.model.LoginModel;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.BindingResult;


@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping("/")
    public String displayLoginForm(Model model){

        model.addAttribute("loginModel", new LoginModel());
        return "LoginForm";
        //return "Hello people";
    }

    @PostMapping("/processLogin")
    public String processLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("loginModel",loginModel);
            return "LoginForm";
        }else{
            System.out.println("Username: "+loginModel.getUsername());
            System.out.println("Password: "+loginModel.getPassword());
            System.out.println("Results: "+bindingResult);
        }
        model.addAttribute("loginModel", loginModel);
        return "LoginResult";
    }
}