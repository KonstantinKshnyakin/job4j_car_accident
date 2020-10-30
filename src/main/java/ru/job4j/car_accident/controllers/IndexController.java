package ru.job4j.car_accident.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        ArrayList<String> users = new ArrayList<>();
        users.add("KOstya");
        users.add("Danya");
        users.add("Vlad");
        model.addAttribute("users", users);
        return "index";
    }
}