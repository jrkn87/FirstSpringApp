package pl.duhc.springstart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.duhc.springstart.domain.Quest;
import pl.duhc.springstart.domain.repository.KnightRepository;
import pl.duhc.springstart.domain.repository.QuestRepository;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class QuestService {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    final static Random rand = new Random();

    public void assingRandomQuest(String knightName) {
        List<Quest> allQuest = questRepository.getAllQuest();
        Quest randomQuest = allQuest.get(rand.nextInt(allQuest.size()));
        knightRepository.getKnight(knightName).ifPresent(knight -> knight.setQuest(randomQuest));
        questRepository.deleteQuest(randomQuest);
    }

    public List<Quest> getAllQuestNotStarted() {
        return questRepository.getAllQuest().stream().filter(quest -> !quest.isStarted()).collect(Collectors.toList());
    }

    public void updateQuest(Quest quest) {
        questRepository.updateQuest(quest);
    }
}
