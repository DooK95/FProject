package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Coach;
import pl.coderslab.model.Group;
import pl.coderslab.model.GroupStatus;
import pl.coderslab.model.TrainingDay;
import pl.coderslab.service.CoachService;
import pl.coderslab.service.GroupService;
import pl.coderslab.service.TrainingsService;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    GroupService groupService;

    @Autowired
    TrainingsService trainingsService;

    @Autowired
    CoachService coachService;

    @ModelAttribute("trainings")
    public List<TrainingDay> trainingDays() {
        return trainingsService.findAll();
    }

    @ModelAttribute("coaches")
    public List<Coach> coaches() {
        return coachService.findAll();
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("group", new Group());
        return "groupForm";
    }

    @Valid
    @PostMapping("/add")
    public String add(@ModelAttribute @Valid Group group, BindingResult result) {
        if (result.hasErrors()) {
            return "groupForm";
        }
        groupService.save(group);
        return "redirect:show";
    }

    @GetMapping("/update/{id}")
    public String getUpD(@PathVariable long id, Model model) {
        Group group = groupService.findById(id);
        model.addAttribute(group);
        return "coachForm";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute Group group) {
        groupService.save(group);
        return "redirect:../show";
    }


    @GetMapping("/show/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("groups", groupService.findById(id));
        return "coachList";
    }

    @GetMapping("/show")
    public String show(Model model) {
        model.addAttribute("groups", groupService.findAll());
        return "coachList";
    }
}