package pl.duhc.springstart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.duhc.springstart.services.KnightService;

@Controller
public class KnightsController {

    @Autowired
    KnightService knightService;

    @RequestMapping("/knights")
    public String getAllKnights(Model model) {
        model.addAttribute("knights", knightService.getAllKnights());
        model.addAttribute("title", "Loc'tar Ogar!");
        return "knights";
    }
}
