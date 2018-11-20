package pl.duhc.springstart.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import pl.duhc.springstart.components.TimeComponent;
import pl.duhc.springstart.domain.Quest;
import pl.duhc.springstart.utils.Ids;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.*;

@Repository
public class QuestRepository {

    Map<Integer, Quest> quests = new HashMap<>();
    final static Random rand = new Random();

    public void createQuest(String description) {
        Integer newId = Ids.addNewId(quests.keySet());
        Quest quest = new Quest(newId, description);
        quests.put(newId, quest);
    }

    public void deleteQuest(Quest quest) {
        quests.remove(quest.getId());
    }

    public List<Quest> getAllQuest() {
        return new ArrayList<>(quests.values());
    }

    public void updateQuest(int id, Quest quest) {
        quests.put(id, quest);
    }

    @Scheduled(fixedDelayString = "${questdelay.value}")
    public void createRandomQuest() {
        List<String> descriptions = new ArrayList<>();

        descriptions.add("Rescue the Princes!");
        descriptions.add("Kill the dragon.");
        descriptions.add("Kill goblins band.");
        descriptions.add("Find a gold key nea..");

        String description = descriptions.get(rand.nextInt(descriptions.size()));
        System.out.println(description);

        createQuest(description);
    }

    @Override
    public String toString() {
        return "QuestRepository{" +
                "questsList=" + quests +
                '}';
    }

    public Quest getId(Integer id) {
        return quests.get(id);
    }
}
