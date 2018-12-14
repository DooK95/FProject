package pl.coderslab.controller;

import org.apache.pdfbox.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Group;
import pl.coderslab.model.Player;
import pl.coderslab.model.PlayerStatus;
import pl.coderslab.service.GroupService;
import pl.coderslab.service.PlayerService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
    public String add(@ModelAttribute @Valid Player player, Model model, BindingResult result) {
        if (result.hasErrors()) {
            return "playersForm";
        }
        player.setStatus(PlayerStatus.UNACTIVE);
        playerService.save(player);
        return "redirect:/players/pdf/"+player.getId();
    }

    @GetMapping("/pdf/{id}")
    public void getImageAsByteArray(HttpServletResponse response, @PathVariable long id) throws IOException {
        Player player = playerService.findById(id);
        playerService.printPdf(player);
        InputStream in = new FileInputStream("/home/adrian/Pulpit/Kurs/apache-tomcat-9.0.12/bin/Karta"+player.getFirstName()+player.getSecondName()+player.getId()+".pdf");
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }

    @GetMapping("/update/{id}")
    public String getUpD(@PathVariable long id, Model model) {
        Player player = playerService.findById(id);
        model.addAttribute(player);
        return "playersForm";
    }

    @Valid
    @PostMapping("/update/{id}")
    public String update(@ModelAttribute @Valid Player player,@PathVariable long id, BindingResult result) {
        if (result.hasErrors()) {
            return "playersForm";
        }
        playerService.save(player);
        return "redirect:../show";
    }


    @GetMapping("/show/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("players", playerService.findByIdToArray(id));
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