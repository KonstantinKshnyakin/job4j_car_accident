package ru.job4j.car_accident.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.car_accident.service.AccidentService;

@Controller
public class IndexController {

    private final AccidentService accidentService;

    public IndexController(AccidentService accidentService) {
        this.accidentService = accidentService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("accidents", accidentService.getAll());
        return "index";
    }
}