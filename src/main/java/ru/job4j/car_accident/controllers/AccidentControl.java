package ru.job4j.car_accident.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.car_accident.models.Accident;
import ru.job4j.car_accident.service.AccidentService;
import ru.job4j.car_accident.service.AccidentTypeService;

@Controller
public class AccidentControl {

    private final AccidentService accidentService;
    private final AccidentTypeService accidentTypeService;

    public AccidentControl(AccidentService accidentService, AccidentTypeService accidentTypeService) {
        this.accidentService = accidentService;
        this.accidentTypeService = accidentTypeService;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", accidentTypeService.getAll());
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident) {
        int typeId = accident.getType().getId();
        accident.setType(accidentTypeService.findById(typeId));
        accidentService.save(accident);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        Accident accident = accidentService.findById(id);
        model.addAttribute("accident", accident);
        return "accident/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Accident accident) {
        accidentService.update(accident);
        return "redirect:/";
    }
}
