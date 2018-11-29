package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.TrainingDay;
import pl.coderslab.model.WeekDays;
import pl.coderslab.service.TrainingsService;

import javax.validation.Valid;

@Controller
@RequestMapping("/trainings")
public class TrainingController {

    @Autowired
    TrainingsService trainingsService;

    @ModelAttribute("weekDays")
    public WeekDays[] weekDays() {
        return WeekDays.values();
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("training", new TrainingDay());
        return "trainingForm";
    }

    @Valid
    @PostMapping("/add")
    public String add(@ModelAttribute @Valid TrainingDay trainingDay, BindingResult result) {
        if (result.hasErrors()) {
            return "trainingForm";
        }
        trainingsService.save(trainingDay);
        return "redirect:../groups/add";
    }
}
