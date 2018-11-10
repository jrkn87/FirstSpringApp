package pl.duhc.springstart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.duhc.springstart.components.TimeComponent;
import pl.duhc.springstart.domain.Knight;
import pl.duhc.springstart.domain.PlayerInfo;
import pl.duhc.springstart.services.KnightService;

import javax.validation.Valid;

@Controller
public class KnightsController {

    @Autowired
    KnightService knightService;

    @Autowired
    TimeComponent timeComponent;

    @Autowired
    PlayerInfo playerInfo;

/*
 *   GET -methods
 */

    @RequestMapping("/knights")
    public String getAllKnights(Model model) {
        model.addAttribute("knights", knightService.getAllKnights());
        model.addAttribute("title", "Loc'tar Ogar!");
        model.addAttribute("time", timeComponent);
        model.addAttribute("goldValue", playerInfo.getGoldValue());
        return "knights";
    }

    @RequestMapping("/newknight")
    public String createKnight(Model model) {
        model.addAttribute("knight", new Knight());
        model.addAttribute("time", timeComponent);
        model.addAttribute("goldValue", playerInfo.getGoldValue());
        return "newknight";
    }

    @RequestMapping("/knight")
    public String getKnight(@RequestParam("id") Integer id, Model model) {
        Knight knight = knightService.getKnight(id);
        model.addAttribute("knight", knight);
        model.addAttribute("time", timeComponent);
        model.addAttribute("goldValue", playerInfo.getGoldValue());
        return "knight";
    }

    @RequestMapping("/knight/delete/{id}")
    public String deleteKnight(@PathVariable("id") Integer id) {
        knightService.deleteKnight(id);
        return "redirect:/knights";
    }

/*
 *   POST -methods
 */

    @RequestMapping(value = "/knights", method = RequestMethod.POST)
    public String addKnight(@Valid Knight knight, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            System.out.println("Error");
            return "newknight";
        } else {
            knightService.createKnight(knight);
            return "redirect:/knights";
        }
    }
}
