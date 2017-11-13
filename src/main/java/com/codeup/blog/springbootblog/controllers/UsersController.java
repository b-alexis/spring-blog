package com.codeup.blog.springbootblog.controllers;

import com.codeup.blog.springbootblog.models.User;
import com.codeup.blog.springbootblog.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {
    private UsersRepository repository;
    private PasswordEncoder encoder;

    @Autowired
    public UsersController(UsersRepository repository, PasswordEncoder passwordEncoder){
        this.repository= repository;
        this.encoder = encoder;
    }

    @GetMapping("/registration")
    public String showSignUpForm(Model model){
        model.addAttribute("user",new User());
        return "users/registration";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute User user){
        String hash= encoder.encode(user.getPassword());
        repository.save(user);
        return "redirect:/login";
    }
}
