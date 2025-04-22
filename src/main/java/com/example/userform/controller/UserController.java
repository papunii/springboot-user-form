package com.example.userform.controller;

import com.example.userform.model.User;
import com.example.userform.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserRepository userRepo;

    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userRepo.findAll());
        return "index";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute User user) {
        userRepo.save(user);
        return "redirect:/";
    }
}
