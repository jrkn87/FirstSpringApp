package pl.duhc.springstart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.duhc.springstart.components.TimeComponent;
import pl.duhc.springstart.domain.Knight;
import pl.duhc.springstart.domain.PlayerInfo;
import pl.duhc.springstart.domain.Quest;
import pl.duhc.springstart.services.KnightService;
import pl.duhc.springstart.services.QuestService;

import java.util.List;

@Controller
public class QuestController {

    @Autowired
    KnightService knightService;

    @Autowired
    QuestService questService;

    @Autowired
    TimeComponent timeComponent;

    @Autowired
    PlayerInfo playerInfo;

    /*
     *  GET
     */

    @RequestMapping("/assignQuest")
    public String getAssignQuest(@RequestParam("knightId") Integer id, Model model) {
        Knight knight = knightService.getKnight(id);
        List<Quest> allQuestNotStarted = questService.getAllQuestNotStarted();
        model.addAttribute("time", timeComponent.toString());
        model.addAttribute("goldValue", playerInfo.getGoldValue());
        model.addAttribute("knight", knight);
        model.addAttribute("allQuestNotStarted", allQuestNotStarted);
        return "assignQuest";
    }

    @RequestMapping(value = "/assignQuest", method = RequestMethod.POST)
    public String setAssignQuest(Knight knight){
        knightService.updateKnight(knight);
        questService.updateQuest(knight.getQuest());
        return "redirect:/knights";
    }

    @RequestMapping("/check")
    public String checkQuestStatus() {
        knightService.getMyGold();
        return "redirect:/knights";
    }
}
