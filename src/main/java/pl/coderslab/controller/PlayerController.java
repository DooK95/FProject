package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Group;
import pl.coderslab.model.Player;
import pl.coderslab.service.GroupService;
import pl.coderslab.service.PlayerService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @Autowired
    GroupService groupService;

    @ModelAttribute("groups")
    public List<Group> coaches() {
        return groupService.findAll();
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("player", new Player());
        return "playersForm";
    }

    @Valid
    @PostMapping("/add")
    public String add(@ModelAttribute @Valid Player player, BindingResult result) {
        if (result.hasErrors()) {
            return "playersForm";
        }
        playerService.save(player);
        return "redirect:show";
    }

    @GetMapping("/update/{id}")
    public String getUpD(@PathVariable long id, Model model) {
        Player group = playerService.findById(id);
        model.addAttribute(group);
        return "playerForm";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute Player player) {
        playerService.save(player);
        return "redirect:../show";
    }


    @GetMapping("/show/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("players", playerService.findById(id));
        return "playerList";
    }

    @GetMapping("/show")
    public String show(Model model) {
        model.addAttribute("players", playerService.findAll());
        return "playerList";
    }

    @GetMapping("/delete/{id}")
    public String del(@PathVariable long id) {
        playerService.del(id);
        return "redirect:../show";
    }
}