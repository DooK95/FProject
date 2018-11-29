package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Coach;
import pl.coderslab.model.CoachPermision;
import pl.coderslab.model.Group;
import pl.coderslab.service.CoachService;
import pl.coderslab.service.GroupService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/coach")
public class CoachController {

    @Autowired
    CoachService coachService;

    @Autowired
    GroupService groupService;

    @ModelAttribute("groups")
    public List<Group> groups() {
        return groupService.findAll();
    }

    @ModelAttribute("permissions")
    public CoachPermision[] permissions() {
        return CoachPermision.values();
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("coach", new Coach());
        return "coachForm";
    }

    @Valid
    @PostMapping("/add")
    public String add(@ModelAttribute @Valid Coach coach, BindingResult result) {
        if (result.hasErrors()) {
            return "coachForm";
        }
        coachService.save(coach);
        return "redirect:show";
    }

    @GetMapping("/update/{id}")
    public String getUpD(@PathVariable long id, Model model) {
        Coach coach = coachService.findById(id);
        model.addAttribute(coach);
        return "coachForm";
    }

    @Valid
    @PostMapping("/update/{id}")
    public String update(@ModelAttribute @Valid Coach coach, BindingResult result) {
        if (result.hasErrors()) {
            return "coachForm";
        }
        coachService.save(coach);
        return "redirect:../show";
    }


    @GetMapping("/show/{id}")
    public String show(@PathVariable int id, Model model) {
        model.addAttribute("coaches", coachService.findByIdToArray(id));
        return "coachList";
    }

    @GetMapping("/show")
    public String show(Model model) {
        model.addAttribute("coaches", coachService.findAll());
        return "coachList";
    }

    @GetMapping("/delete/{id}")
    public String del(@PathVariable long id) {
        coachService.del(id);
        return "redirect:../show";
    }
}
