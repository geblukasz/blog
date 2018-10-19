package com.akademiakodu.blog.controller;

import com.akademiakodu.blog.models.entities.User;
import com.akademiakodu.blog.models.forms.LoginForm;
import com.akademiakodu.blog.models.forms.RegisterForm;
import com.akademiakodu.blog.repositories.UserRepository;
import com.akademiakodu.blog.service.UserSessionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

     private UserRepository userRepository;
     private UserSessionService userSessionService;
     private ModelMapper modelMapper;

     @Autowired
     public UserController(UserRepository userRepository, UserSessionService userSessionService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userSessionService = userSessionService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute @Valid RegisterForm form, BindingResult bindingResult, Model model){
         if (bindingResult.hasErrors()){
             return "register";
         }

         User user = modelMapper.map(form, User.class);
         userRepository.save(user);

         return "index";
    }

    public String registerPage(Model model){
         model.addAttribute("registerForm", new RegisterForm()); // ${}
        return "register";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute @Valid LoginForm loginForm, BindingResult bindingResult, Model model){
         boolean logged = userSessionService.loginUser(loginForm.getUserName(), loginForm.getPassword());
         if (!logged){
             bindingResult.reject("userName", null,"Uzytkownik nie istnieje");
         }
         if (bindingResult.hasErrors()){
             return "login";
         }

         model.addAttribute("loggedUser", logged);
         return "redirect:/";
    }

    @GetMapping("/login")
    public String loginPage(Model model){
         model.addAttribute("loginForm", new LoginForm());
         return "login";
    }
}
