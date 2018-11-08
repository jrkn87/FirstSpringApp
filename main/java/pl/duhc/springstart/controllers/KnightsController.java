package pl.duhc.springstart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.duhc.springstart.domain.Knight;
import pl.duhc.springstart.services.KnightService;

@Controller
public class KnightsController {

    @Autowired
    KnightService knightService;

    /*
     *   GET -methods
     */

    @RequestMapping("/knights")
    public String getAllKnights(Model model) {
        model.addAttribute("knights", knightService.getAllKnights());
        model.addAttribute("title", "Loc'tar Ogar!");
        return "knights";
    }

    @RequestMapping("/newknight")
    public String createKnight(Model model) {
        model.addAttribute("knight", new Knight());
        return "newknight";
    }

    /*
     *   POST -methods
     */

    @RequestMapping(value = "/knights", method = RequestMethod.POST)
    public String addKnight(Knight knight) {
        knightService.createKnight(knight);
        return "redirect:/knights";
    }
}
